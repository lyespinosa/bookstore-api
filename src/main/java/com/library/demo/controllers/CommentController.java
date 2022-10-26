package com.library.demo.controllers;


import com.library.demo.controllers.dtos.requests.BookRequest;
import com.library.demo.controllers.dtos.requests.CommentRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Comment;
import com.library.demo.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping("")
    public ResponseEntity<BaseResponse> listComments(){
        BaseResponse baseResponse = service.listComments();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> addComment(@RequestBody CommentRequest request){
        BaseResponse baseResponse = service.addComment(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
