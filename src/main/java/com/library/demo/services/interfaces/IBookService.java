package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.BookRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;

public interface IBookService {
    BaseResponse listBooks();

    BaseResponse getBookById(Long id);

    BaseResponse getBookByName(String name);

    BaseResponse addBook(BookRequest request);

    BaseResponse updateBookById(Long id, BookRequest request);

    BaseResponse deleteBookById(Long id);
}
