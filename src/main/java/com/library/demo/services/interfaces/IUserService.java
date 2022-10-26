package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.UserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse listUsers();

    BaseResponse getUserById(Long id);

    BaseResponse getUserByEmail(String email);

    BaseResponse createUser(UserRequest request);

    BaseResponse updateUserById(Long id, UserRequest request);

    BaseResponse deleteUserById(Long id);
}
