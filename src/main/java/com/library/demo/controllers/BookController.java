package com.library.demo.controllers;

import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
