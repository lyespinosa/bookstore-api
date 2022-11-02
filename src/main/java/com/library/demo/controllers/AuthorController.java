package com.library.demo.controllers;

import com.library.demo.controllers.dtos.requests.CreateAuthorRequest;
import com.library.demo.controllers.dtos.requests.UpdateAuthorRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private IAuthorService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listAuthors(){
        BaseResponse baseResponse = service.listAuthors();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/name")
    public ResponseEntity<BaseResponse> listAllName(){
        BaseResponse baseResponse = service.listAuthors();
        return  new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getAuthorById(@PathVariable Long id){
        BaseResponse  baseResponse = service.getAuthorById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<BaseResponse> getAuthorByName(@PathVariable String name){
        BaseResponse baseResponse = service.getAuthorByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateAuthorRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateAuthorRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }
}
