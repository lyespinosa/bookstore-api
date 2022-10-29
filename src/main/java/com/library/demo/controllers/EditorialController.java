package com.library.demo.controllers;

import com.library.demo.controllers.dtos.requests.AuthorRequest;
import com.library.demo.controllers.dtos.requests.EditorialRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("editorial")
public class EditorialController {

    @Autowired
    private IEditorialService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listEditorials(){
        BaseResponse baseResponse = service.listEditorials();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/name")
    public ResponseEntity<BaseResponse> listAllName(){
        BaseResponse baseResponse = service.listEditorials();
        return  new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getEditorialById(@PathVariable Long id){
        BaseResponse  baseResponse = service.getEditorialById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<BaseResponse> getEditorialByName(@PathVariable String name){
        BaseResponse baseResponse = service.getEditorialByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid EditorialRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid EditorialRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }

}