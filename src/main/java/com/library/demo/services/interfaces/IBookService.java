package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.responses.BaseResponse;

public interface IBookService {
    BaseResponse listBooks();

    BaseResponse getBook();

    BaseResponse setBook();

    BaseResponse updateBook();

    BaseResponse deleteBook();
}
