package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateCommentRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;

public interface ICommentService {
    BaseResponse listAllCommentsByBookId(Long id);

    BaseResponse create(CreateCommentRequest request);
}
