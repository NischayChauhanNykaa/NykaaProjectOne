package com.example.demo.Services.Impl;

import com.example.demo.Converter.UserConverter;
import com.example.demo.Services.Structure.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
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
                logger.error("Invalid user details:\n " + userDto.toString());
                throw new Exception("Invalid details");
            }
            String email = userDto.getEmail();
            if(email != null && !"".equals(email)) {
                User user = userRepository.findByEmailAndDeleted(email, false);
                if(user != null) {
                    responseDto.setHttpStatus(409);
                    logger.error("User with email id {} already exists", email);
                    throw new Exception("User with the email " + email + " already exists");
                }
            }
            userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            User user = userRepository.save(userConverter.dtoToEntity(userDto));
            responseDto.setData(userConverter.entityToDto(user));
            responseDto.setSuccess(true);
            responseDto.setMessage("User registered successfully");
            responseDto.setHttpStatus(200);
            logger.info("User {} registered successfully with email {}", user.getUserId(), user.getEmail());
        } catch (Exception e) {
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
                logger.error("User with id {} does not exist", id);
                throw new Exception("User with id " + id + " not found");
            }
            responseDto.setData(userConverter.entityToDto(user));
            responseDto.setSuccess(true);
            responseDto.setHttpStatus(200);
            responseDto.setMessage("User found");
            logger.info("User with id {} found", id);
        } catch (Exception e) {
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
                logger.info("User with email {} logged in successfully", email);
            } else {
                logger.error("Error while logging in with email {}", email);
                throw new Exception("Invalid email or password\nemail - " + email);
            }
        }catch (Exception e) {
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
                logger.error("User with id {} does not exist", id);
                throw new Exception("User with id " + id + " not found");
            }
            user.setDeleted(true);
            userRepository.save(user);
            responseDto.setSuccess(true);
            responseDto.setMessage("User deleted successfully");
            responseDto.setHttpStatus(200);
            logger.info("User with id {} deleted successfully", id);
        } catch (Exception e) {
            responseDto.setMessage(e.getMessage());
            responseDto.setSuccess(false);
        }
        return responseDto;
    }

    @Override
    public ResponseDto update(UserDto userDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            if(userDto == null) {
                responseDto.setHttpStatus(404);
                logger.error("Invalid user details");
                throw new Exception("Invalid details");
            }
            User user = userRepository.findByUserId(userDto.getUserId());
            if(user == null || user.isDeleted()){
                responseDto.setHttpStatus(404);
                logger.error("User with id {} does not exist", userDto.getUserId());
                throw new Exception("User with id " + userDto.getUserId() + " not found");
            }
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
            logger.info("User {} details updated successfully", user.getUserId());
        } catch (Exception e) {
            responseDto.setSuccess(false);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }
}
