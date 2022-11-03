package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateUserRequest;
import com.library.demo.controllers.dtos.requests.UpdateUserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.UserResponse;
import com.library.demo.controllers.exceptions.BookException;
import com.library.demo.entities.User;
import com.library.demo.repositories.IUserRepository;
import com.library.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow( () -> new BookException("User not found"));
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    @Override
    public BaseResponse listUsers() {
        List<UserResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("User list")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getUserById(Long id) {
        UserResponse response = from(findUserById(id));
        return BaseResponse.builder()
                .data(response)
                .message("User by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getUserByEmail(String email) {
        UserResponse response = from(findUserByEmail(email));
        return BaseResponse.builder()
                .data(response)
                .message("User by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getUserByPassword(String password) {
       UserResponse response = from(findUserByPassword(password));
        return BaseResponse.builder()
                .data(response)
                .message("User by password")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private User findUserByPassword(String password) {return repository.getUserByPassword(password);}

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = new User();
        user = create(request, user);
        UserResponse response = from(repository.save(user));
        return BaseResponse.builder()
                .data(response)
                .message("User created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateUserRequest request) {
        User user = findUserById(id);
        user = update(request, user);
        UserResponse response = from(repository.save(user));
        return BaseResponse.builder()
                .data(response)
                .message("User updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }

    private User create(CreateUserRequest request, User user){
        user.setName(request.getName());
        return user;
    }

    private User update(UpdateUserRequest request, User user){
        user.setName(request.getName());
        return user;
    }
}
