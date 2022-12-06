package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.requests.CreateBookRequest;
import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.BookResponse;
import com.bookstore.entities.Book;
import com.bookstore.entities.projections.BookProjection;
import com.bookstore.controllers.dtos.requests.UpdateBookRequest;

import java.util.List;

public interface IBookService {

    Book findBookById(Long id);

    List<BookProjection> findBookByName(String name);

    BaseResponse listBooks();

    BaseResponse listRandBooks();

    BaseResponse listNewBooks();

    BaseResponse listOldBooks();

    BaseResponse getBookById(Long id);

    BaseResponse getBookByName(String name);

    BaseResponse create(CreateBookRequest request);

    BaseResponse update(Long id, UpdateBookRequest request);

    void delete(Long id);

    BookResponse from(BookProjection book);

}
