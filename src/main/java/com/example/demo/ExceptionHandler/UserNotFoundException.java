package com.example.demo.ExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id) {
        super("User with id " + id + " not found");
    }
}
