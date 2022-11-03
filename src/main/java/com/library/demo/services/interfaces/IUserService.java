package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateUserRequest;
import com.library.demo.controllers.dtos.requests.UpdateUserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.User;

public interface IUserService {

    User findUserById(Long id);

    User findUserByEmail(String email);


    BaseResponse listUsers();

    BaseResponse getUserById(Long id);

    BaseResponse getUserByEmail(String email);

    BaseResponse getUserByPassword(String password);

    BaseResponse create(CreateUserRequest request);

    BaseResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);

}
