package com.example.demo.Services.Impl;

import com.example.demo.Converter.UserConverter;
import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean save(UserDto userDto) {
        if(userDto == null) return false;
        try {
            String email = userDto.getEmail();
            if(email != null && !"".equals(email)) {
                User user = userRepository.findByEmail(email);
                if(user != null) {
                    throw new Exception("User with this Email already exists");
                };
            }
            userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            userRepository.save(userConverter.dtoToEntity(userDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public UserDto fetch(long id) {
        User user = userRepository.findByUserId(id);
        if(user == null || user.isDeleted()) return null;
        return userConverter.entityToDto(user);
    }

    @Override
    public boolean login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        User user = userRepository.findByEmail(email);
        return user != null && !user.isDeleted() && bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean delete(long id) {
        User user = userRepository.findByUserId(id);
        if(user == null) return false;
        user.setDeleted(true);
        return true;
    }

    @Override
    public boolean update(UserDto userDto) {
        if(userDto == null || userDto.getUserId()==0) return false;
        User user = userRepository.findByUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setState(userDto.getState());
        user.setZip(userDto.getZip());
        userRepository.save(user);
        return true;
    }
}
