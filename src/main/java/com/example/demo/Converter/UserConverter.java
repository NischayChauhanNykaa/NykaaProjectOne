package com.example.demo.Converter;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto entityToDto(User user) {
        if(user == null) return null;

        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setState(user.getState());
        userDto.setZip(user.getZip());

        return  userDto;
    }

    public User dtoToEntity(UserDto userDto) {
        if(userDto == null) return  null;
        User user = new User();

        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setState(userDto.getState());
        user.setZip(userDto.getZip());

        return user;
    }

}
