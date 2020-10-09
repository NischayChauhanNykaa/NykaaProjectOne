package com.example.demo.Services.Structure;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;

public interface UserService {

    public abstract ResponseDto save(UserDto userDto);

    public abstract UserDto fetch(long id);

    public abstract boolean login(LoginDto loginDto);

    public abstract boolean delete(long id);

    public abstract boolean update(UserDto userDto);

}
