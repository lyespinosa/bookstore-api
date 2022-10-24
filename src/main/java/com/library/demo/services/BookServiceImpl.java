package com.library.demo.services;

import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.repositories.IBookRepository;
import com.library.demo.services.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository repository;

    @Override
    public BaseResponse listBooks() {
        List<BookResponse> response = repository.listBooks().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("All books")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getBook() {
        return null;
    }

    @Override
    public BaseResponse setBook() {
        return null;
    }

    @Override
    public BaseResponse updateBook() {
        return null;
    }

    @Override
    public BaseResponse deleteBook() {
        return null;
    }

    private BookResponse from(BookProjection book){
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setName(book.getName());
        response.setDescription(book.getDescription());
        response.setAuthorName(book.getAuthorName());
        response.setEditorialName(book.getEditorialName());
        response.setYear(book.getYear());
        response.setPrice(book.getPrice());
        return response;
    }
}
