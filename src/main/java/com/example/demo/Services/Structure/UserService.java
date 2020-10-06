package com.example.demo.Services.Structure;

import com.example.demo.dto.UserDto;

public interface UserService {

    public abstract boolean save(UserDto userDto);

    public abstract UserDto fetch(long id);

    public abstract boolean login(UserDto userDto);

    public abstract boolean delete(UserDto userDto);

    public abstract boolean update(UserDto userDto);

}
