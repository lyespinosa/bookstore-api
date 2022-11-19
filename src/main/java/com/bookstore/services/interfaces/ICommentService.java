package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Comment;
import com.bookstore.controllers.dtos.requests.CreateCommentRequest;

public interface ICommentService {

    Comment findCommentById(Long id);
    BaseResponse listAllCommentsByBookId(Long id);

    BaseResponse create(CreateCommentRequest request);

    void delete(Long id);
}
