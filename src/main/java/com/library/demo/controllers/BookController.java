package com.library.demo.controllers;

import com.library.demo.controllers.dtos.requests.BookRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private IBookService service;

        @GetMapping("")
    public ResponseEntity<BaseResponse> listBooks(){
        BaseResponse baseResponse = service.listBooks();
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
    public ResponseEntity<BaseResponse> addBook(@RequestBody BookRequest request){
        BaseResponse baseResponse = service.addBook(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BaseResponse> updateBookById(@PathVariable Long id, @RequestBody BookRequest request){
        BaseResponse baseResponse = service.updateBookById(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<BaseResponse> deleteBookById(@PathVariable Long id){
        BaseResponse baseResponse = service.deleteBookById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
