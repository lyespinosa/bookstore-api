package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CommentRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Comment;

public interface ICommentService {
    BaseResponse listComments();

    BaseResponse addComment(CommentRequest request);
}
