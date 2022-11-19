package com.bookstore.controllers;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.services.interfaces.IGenderService;
import com.bookstore.controllers.dtos.requests.CreateGenderRequest;
import com.bookstore.controllers.dtos.requests.UpdateGenderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("gender")
public class GenderController {

    @Autowired
    private IGenderService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listGenders(){
        BaseResponse baseResponse = service.listGenders();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/name")
    public ResponseEntity<BaseResponse> listAllName(){
        BaseResponse baseResponse = service.listGenders();
        return  new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getGenderById(@PathVariable Long id){
        BaseResponse  baseResponse = service.getGenderById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<BaseResponse> getGenderByName(@PathVariable String name){
        BaseResponse baseResponse = service.getGenderByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateGenderRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateGenderRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}
