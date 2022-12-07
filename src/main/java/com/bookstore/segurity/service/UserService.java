package com.bookstore.segurity.service;

import com.bookstore.controllers.dtos.requests.AuthenticateUserRequest;
import com.bookstore.controllers.dtos.requests.CreateUserRequest;
import com.bookstore.controllers.dtos.requests.UpdateUserRequest;
import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.UserResponse;
import com.bookstore.controllers.exceptions.BookException;
import com.bookstore.segurity.entity.User;
import com.bookstore.segurity.repository.UserRepository;
import com.bookstore.segurity.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    UserRepository repository;

    public Optional<User> getByUserName(String userName){
        return repository.findByUserName(userName);
    }

    public User getNOByUserName(String userName){
        return repository.findNOByUserName(userName);
    }


    public boolean existsByUserName(String userName){
        return repository.existsByUserName(userName);
    }

    public boolean existsByEmail(String email){
        return repository.existsByEmail(email);
    }

    public void save(User user){
        repository.save(user);
    }

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
    public BaseResponse getUserByUserName(String userName) {
        UserResponse response = from(getNOByUserName(userName));
        return BaseResponse.builder()
                .data(response)
                .message("User by userName")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getUserByEmailAndPassword(AuthenticateUserRequest request) {
        User user = repository.getUserByEmailAndPassword(request.getEmail(), request.getPassword());

        if(user == null) {
            throw new BookException("User incorrect");
        }

        UserResponse response = from(user);

        return BaseResponse.builder()
                .data(response)
                .message("User correct")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }



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
        findUserById(id);
        repository.deleteById(id);
    }

    private UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setBirth(user.getBirth());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setAddress(user.getAddress());
        response.setAdmin(user.getAdmin());
        return response;
    }

    private User create(CreateUserRequest request, User user){
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setBirth(request.getBirth());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        user.setAdmin(request.getAdmin());
        return user;
    }

    private User update(UpdateUserRequest request, User user){
        if(request.getName() != null){
            user.setName(request.getName());}
        if(request.getLastName() != null){
            user.setLastName(request.getLastName());}
        if(request.getUserName() != null){
            user.setUserName(request.getUserName());}
        if(request.getEmail() != null){
            user.setEmail(request.getEmail());}
        if(request.getPassword() != null){
            user.setPassword(request.getPassword());}
        if(request.getBirth() != null){
            user.setBirth(request.getBirth());}
        if(request.getPhoneNumber() != null){
            user.setPhoneNumber(request.getPhoneNumber());}
        if(request.getAddress() != null){
            user.setAddress(request.getAddress());}
        return user;
    }

}
