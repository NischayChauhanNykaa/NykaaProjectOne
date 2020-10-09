package com.example.demo.Services.Structure;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;

public interface UserService {

    ResponseDto save(UserDto userDto);

    ResponseDto fetch(long id);

    ResponseDto login(LoginDto loginDto);

    ResponseDto delete(long id);

    ResponseDto update(UserDto userDto);

}
