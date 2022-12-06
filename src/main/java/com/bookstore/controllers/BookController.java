package com.bookstore.controllers;

import com.bookstore.controllers.dtos.requests.CreateBookRequest;
import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.requests.UpdateBookRequest;
import com.bookstore.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping("healthy")
    public String healthy(){
        return "healthy";
    }

    @GetMapping
    public ResponseEntity<BaseResponse> listBooks(){
        BaseResponse baseResponse = service.listBooks();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("random")
    public ResponseEntity<BaseResponse> listRandBooks(){
        BaseResponse baseResponse = service.listRandBooks();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("new")
    public ResponseEntity<BaseResponse> listNewBooks(){
        BaseResponse baseResponse = service.listNewBooks();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("old")
    public ResponseEntity<BaseResponse> listOldBooks(){
        BaseResponse baseResponse = service.listOldBooks();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getBookById(@PathVariable Long id){
        BaseResponse baseResponse = service.getBookById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<BaseResponse> getBookByName(@PathVariable String name){
        BaseResponse baseResponse = service.getBookByName(name);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateBookRequest request){
        BaseResponse baseResponse = service.create(request);
            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateBookRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
