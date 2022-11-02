package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateBookRequest;
import com.library.demo.controllers.dtos.requests.UpdateBookRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.entities.Book;
import com.library.demo.entities.projections.BookProjection;

import java.util.List;

public interface IBookService {

    Book findBookById(Long id);

    List<BookProjection> findBookByName(String name);

    BaseResponse listBooks();

    BaseResponse getBookById(Long id);

    BaseResponse getBookByName(String name);

    BaseResponse create(CreateBookRequest request);

    BaseResponse update(Long id, UpdateBookRequest request);

    void delete(Long id);

    BookResponse from(BookProjection book);

}
