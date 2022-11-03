package com.library.demo.controllers;

import com.library.demo.controllers.dtos.requests.AuthenticateUserRequest;
import com.library.demo.controllers.dtos.requests.CreateUserRequest;
import com.library.demo.controllers.dtos.requests.UpdateUserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listUsers(){
        BaseResponse baseResponse = service.listUsers();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getUserById(@PathVariable Long id){
        BaseResponse baseResponse = service.getUserById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("login")
    public ResponseEntity<BaseResponse> getUserByEmailAndPassword(@RequestBody @Valid AuthenticateUserRequest request){
        BaseResponse baseResponse = service.getUserByEmailAndPassword(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateUserRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
       service.delete(id);
    }
}
