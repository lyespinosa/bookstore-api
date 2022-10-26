package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.UserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public BaseResponse listUsers() {
        return null;
    }

    @Override
    public BaseResponse getUserById(Long id) {
        return null;
    }

    @Override
    public BaseResponse getUserByEmail(String email) {
        return null;
    }

    @Override
    public BaseResponse createUser(UserRequest request) {
        return null;
    }

    @Override
    public BaseResponse updateUserById(Long id, UserRequest request) {
        return null;
    }

    @Override
    public BaseResponse deleteUserById(Long id) {
        return null;
    }
}
