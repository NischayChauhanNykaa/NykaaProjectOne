package com.example.demo.Controllers;


import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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
    public ResponseEntity<ResponseDto> getUser(@PathVariable long id) {
        ResponseDto responseDto = userService.fetch(id);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody UserDto userDto) {
        ResponseDto responseDto = userService.save(userDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto loginDto) {
        ResponseDto responseDto = userService.login(loginDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto) {
        ResponseDto responseDto = userService.update(userDto);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteUser(@RequestParam long id) {
        ResponseDto responseDto = userService.delete(id);
        HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
        return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }
}
