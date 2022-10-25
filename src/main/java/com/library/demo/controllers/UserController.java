package com.library.demo.controllers;

import com.library.demo.controllers.dtos.requests.UserRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("")
    public ResponseEntity<BaseResponse> listUsers(){
        BaseResponse baseResponse = service.listUsers();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getUserById(@PathVariable Long id){
        BaseResponse baseResponse = service.getUserById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{email}")
    public ResponseEntity<BaseResponse> getUserByEmail(@PathVariable String email){
        BaseResponse baseResponse = service.getUserByEmail(email);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequest request){
        BaseResponse baseResponse = service.createUser(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BaseResponse> updateUserById(@PathVariable Long id, @RequestBody UserRequest request){
        BaseResponse baseResponse = service.updateUserById(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable Long id){
        BaseResponse baseResponse = service.deleteUserById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
