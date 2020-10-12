package com.example.demo.Controllers;


import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //FOR TESTING
    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable long id) {
        logger.log(Level.INFO,"Request received at getUser with user id {}", id);
        ResponseDto responseDto = userService.fetch(id);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto) {
        logger.log(Level.INFO,"Request received at registerUser with email {}", userDto.getEmail());
        ResponseDto responseDto = userService.save(userDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginDto loginDto) {
        logger.log(Level.INFO,"Request received at loginUser with email {}", loginDto.getEmail());
        ResponseDto responseDto = userService.login(loginDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
        logger.log(Level.INFO,"Request received at updateUser with email {}", userDto.getEmail());
        ResponseDto responseDto = userService.update(userDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam long id) {
        logger.log(Level.INFO,"Request received at deleteUser with user id {}", id);
        ResponseDto responseDto = userService.delete(id);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }
}
