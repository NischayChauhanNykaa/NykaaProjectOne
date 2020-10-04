package com.example.demo.Controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String checkEmail = user.getEmail();
        if(checkEmail != null && !"".equals(checkEmail)) {
            User checkUser = userRepository.findByEmail(checkEmail);
            if(checkUser != null) throw new Exception("User with this Email Id already exists.");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();
        User userObj = userRepository.findByEmail(email);

        if(userObj == null || !bCryptPasswordEncoder.matches(password, userObj.getPassword())) throw (new Exception("Invalid email or password"));
        return userObj;
    }



}
