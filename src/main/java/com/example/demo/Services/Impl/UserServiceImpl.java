package com.example.demo.Services.Impl;

import com.example.demo.Converter.UserConverter;
import com.example.demo.ExceptionHandler.UserNotFoundException;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
//import com.example.demo.dto.UserDetailsDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseDto save(UserDto userDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            if(userDto.getEmail() == null || userDto.getPassword() == null){
                responseDto.setHttpStatus(400);
                throw new Exception("Invalid details");
            }
            String email = userDto.getEmail();
            if(email != null && !"".equals(email)) {
                User user = userRepository.findByEmailAndDeleted(email, false);
                if(user != null) {
                    responseDto.setHttpStatus(409);
                    throw new Exception("User with this Email already exists");
                }
            }
            userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            User user = userRepository.save(userConverter.dtoToEntity(userDto));
            responseDto.setData(userConverter.entityToDto(user));
            responseDto.setSuccess(true);
            responseDto.setMessage("User registered successfully");
            responseDto.setHttpStatus(200);
            logger.info("User registered successful");
        } catch (Exception e) {
            logger.error("Error while registering user : " + e.getMessage());
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto fetch(long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            User user = userRepository.findByUserId(id);
            if(user == null || user.isDeleted()){
                responseDto.setHttpStatus(404);
                throw new Exception("User not found");
            }
            responseDto.setData(userConverter.entityToDto(user));
            responseDto.setSuccess(true);
            responseDto.setHttpStatus(200);
            responseDto.setMessage("User found");
            logger.info("User found");
        } catch (Exception e) {
            logger.error("Error while fetching user : " + e.getMessage());
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }

    @Override
    public ResponseDto login(LoginDto loginDto) {
        ResponseDto responseDto = new ResponseDto();
        try{
            String email = loginDto.getEmail();
            String password = loginDto.getPassword();
            User user = userRepository.findByEmailAndDeleted(email, false);
            boolean val = user != null && !user.isDeleted() && bCryptPasswordEncoder.matches(password, user.getPassword());
            if(val){
                responseDto.setHttpStatus(200);
                responseDto.setMessage("Login successful");
                responseDto.setSuccess(true);
                responseDto.setData(userConverter.entityToDto(user));
                logger.info("User details updated successfully");
            } else {
                throw new Exception("Invalid email or password");
            }
        }catch (Exception e) {
            logger.error("Error at user login : " + e.getMessage());
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
            responseDto.setHttpStatus(401);
        }
        return responseDto;
    }

    @Override
    public ResponseDto delete(long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            User user = userRepository.findByUserId(id);
            if(user == null){
                responseDto.setHttpStatus(404);
                throw new Exception("User not found");
            }
            user.setDeleted(true);
            userRepository.save(user);
            responseDto.setSuccess(true);
            responseDto.setMessage("User deleted successfully");
            responseDto.setHttpStatus(200);
            logger.info("User deleted successfully");
        } catch (Exception e) {
            logger.error("Error while deleting user : " + e.getMessage());
            responseDto.setMessage(e.getMessage());
            responseDto.setSuccess(false);
        }
        return responseDto;
    }

    @Override
    public ResponseDto update(UserDto userDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            if(userDto == null || userDto.getUserId()==0){
                responseDto.setHttpStatus(404);
                throw new Exception("User not found");
            }
            User user = userRepository.findByUserId(userDto.getUserId());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhone(userDto.getPhone());
            user.setAddress(userDto.getAddress());
            user.setCity(userDto.getCity());
            user.setState(userDto.getState());
            user.setZip(userDto.getZip());
            userRepository.save(user);
            responseDto.setSuccess(true);
            responseDto.setHttpStatus(200);
            responseDto.setMessage("User details updated successfully");
            responseDto.setData(userConverter.entityToDto(user));
            logger.info("User details updated successfully");
        } catch (Exception e) {
            logger.error("Error while updating user : " + e.getMessage());
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }
}
