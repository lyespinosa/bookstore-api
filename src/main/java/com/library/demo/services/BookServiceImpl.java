package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.BookRequest;
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
        return buildBaseResponse(response, "All books");
    }

    @Override
    public BaseResponse getBookById(Long id) {
        BookResponse response = from(repository.getBookById(id));
        return buildBaseResponse(response, "Searching Book by Id");
    }

    @Override
    public BaseResponse getBookByName(String name) {
        List<BookResponse> response = repository.getBookByName(name).stream().map(this::from).collect(Collectors.toList());
        return buildBaseResponse(response , "Searching Book by name");
    }

    @Override
    public BaseResponse addBook(BookRequest request) {
        return null;
    }

    @Override
    public BaseResponse updateBookById(Long id, BookRequest request) {
        return null;
    }

    @Override
    public BaseResponse deleteBookById(Long id) {
        return null;
    }

    private BaseResponse buildBaseResponse(List<BookResponse> response, String message){
        return BaseResponse.builder()
                .data(response)
                .message(message)
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private BaseResponse buildBaseResponse(BookResponse response, String message){
        return BaseResponse.builder()
                .data(response)
                .message(message)
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private BookResponse from(BookProjection book){
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setName(book.getName());
        response.setDescription(book.getDescription());
        response.setCover(book.getCover());
        response.setAuthorName(book.getAuthorName());
        response.setEditorialName(book.getEditorialName());
        response.setYear(book.getYear());
        response.setPrice(book.getPrice());
        return response;
    }
}
