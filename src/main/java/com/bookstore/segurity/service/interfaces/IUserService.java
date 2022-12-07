package com.bookstore.segurity.service.interfaces;

import com.bookstore.controllers.dtos.requests.AuthenticateUserRequest;
import com.bookstore.controllers.dtos.requests.CreateUserRequest;
import com.bookstore.controllers.dtos.requests.UpdateUserRequest;
import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.segurity.entity.User;

public interface IUserService {

    User findUserById(Long id);

    User findUserByEmail(String email);

    BaseResponse listUsers();

    BaseResponse getUserById(Long id);

    BaseResponse getUserByUserName(String userName);

    BaseResponse getUserByEmailAndPassword(AuthenticateUserRequest request);

    BaseResponse create(CreateUserRequest request);

    BaseResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);

}
