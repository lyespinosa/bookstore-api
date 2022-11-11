package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateCommentRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Comment;

public interface ICommentService {

    Comment findCommentById(Long id);
    BaseResponse listAllCommentsByBookId(Long id);

    BaseResponse create(CreateCommentRequest request);

    void delete(Long id);
}
