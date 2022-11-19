package com.bookstore.controllers;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.services.interfaces.ICommentService;
import com.bookstore.controllers.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping("book/{id}")
    public ResponseEntity<BaseResponse> listAllCommentsByBookId(@PathVariable Long id){
        BaseResponse baseResponse = service.listAllCommentsByBookId(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateCommentRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
