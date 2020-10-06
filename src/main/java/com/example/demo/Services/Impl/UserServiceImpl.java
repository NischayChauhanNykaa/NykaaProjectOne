package com.example.demo.Services.Impl;

import com.example.demo.Converter.UserConverter;
import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public boolean login(UserDto userDto) {
        return false;
    }

    @Override
    public boolean delete(UserDto userDto) {
        return false;
    }

    @Override
    public boolean update(UserDto userDto) {
        return false;
    }
}
