package com.bookstore.controllers;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.services.interfaces.IStatusService;
import com.bookstore.controllers.dtos.requests.CreateStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("status")
public class StatusController {

    @Autowired
    private IStatusService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listStatus(){
        BaseResponse baseResponse = service.listStatus();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getStatusById(@PathVariable Long id){
        BaseResponse  baseResponse = service.getStatusById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<BaseResponse> getStatusByName(@PathVariable String name){
        BaseResponse baseResponse = service.getStatusByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateStatusRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

}
