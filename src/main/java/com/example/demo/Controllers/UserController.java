package com.example.demo.Controllers;


import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Impl.UserServiceImpl;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //FOR TESTING
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        if(userService.save(userDto))
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        return new ResponseEntity<>("Error while registering user", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();
        User userObj = userRepository.findByEmail(email);
        if(userObj == null || !bCryptPasswordEncoder.matches(password, userObj.getPassword())) return ResponseEntity.status(401).body("Invalid email or password");
        return ResponseEntity.ok().body("Logged in successfully");
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws Exception {
        if(user == null || user.getUserId() == 0) throw new Exception("Invalid user details");
        User userObj = userRepository.findByUserId(user.getUserId());
        userObj.setFirstName(user.getFirstName());
        userObj.setLastName(user.getLastName());
        userObj.setPhone(user.getPhone());
        userObj.setAddress(user.getAddress());
        userObj.setCity(user.getCity());
        userObj.setState(user.getState());
        userObj.setZip(user.getZip());
        return userRepository.save(userObj);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setDeleted(true);
        userRepository.save(user);
        return ResponseEntity.ok().body("User deleted");
    }
}
