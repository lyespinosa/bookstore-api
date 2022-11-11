package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateBookRequest;
import com.library.demo.controllers.dtos.requests.UpdateBookRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.controllers.exceptions.BookException;
import com.library.demo.entities.Author;
import com.library.demo.entities.Book;
import com.library.demo.entities.Editorial;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.repositories.IBookRepository;
import com.library.demo.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository repository;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IEditorialService editorialService;




    @Override
    public Book findBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("The book does not exist"));
    }

    @Override
    public List<BookProjection> findBookByName(String name) {
        return repository.getBookByName(name);
    }

    @Override
    public BaseResponse listBooks() {
        List<BookResponse> response = repository.listBooks().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Books listed")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getBookById(Long id) {
        BookResponse response = from(findBookById(id));
        return BaseResponse.builder()
                .data(response)
                .message("Book searched by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getBookByName(String name) {
        List<BookResponse> response = findBookByName(name).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Books searched by name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateBookRequest request) {

        /*List<BookGenderRequest> requests = request.getGenders().stream().map(genderId -> from(genderId, response.getId())).collect(Collectors.toList());

        Book finalBook = book;
        requests.stream().map(bGRequest -> bookGenderService.create(bGRequest, finalBook)).collect(Collectors.toList());*/

        Book book = new Book();
        book = create(request, book);
        BookResponse response = from(repository.save(book));

        return BaseResponse.builder()
                .data(response)
                .message("Book created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateBookRequest request) {
        Book book = findBookById(id);
        book = update(request, book);
        BookResponse response = from(repository.save(book));
        return BaseResponse.builder()
                .data(response)
                .message("Books updated successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }



    @Override
    public void delete(Long id) {
        findBookById(id);
        repository.deleteById(id);
    }

    public BookResponse from(BookProjection book){
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


    private BookResponse from(Book book){
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setName(book.getName());
        response.setDescription(book.getDescription());
        response.setCover(book.getCover());
        response.setAuthorName( book.getAuthor().getName() );
        response.setEditorialName( book.getEditorial().getName() );

        response.setYear(book.getYear());
        response.setPrice(book.getPrice());
        return response;
    }



    private Book create(CreateBookRequest request, Book book){
        book.setCover(request.getCover());
        book.setDescription(request.getDescription());
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        book.setYear(request.getYear());

        Author author = authorService.findAuthorById(request.getAuthorId());
        book.setAuthor(author);

        Editorial editorial = editorialService.findEditorialById(request.getEditorialId());
        book.setEditorial(editorial);



        return book;
    }

    private Book update(UpdateBookRequest request, Book book){
        book.setCover(request.getCover());
        book.setDescription(request.getDescription());
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        book.setYear(request.getYear());

        Author author = authorService.findAuthorById(request.getAuthorId());
        book.setAuthor(author);

        Editorial editorial = editorialService.findEditorialById(request.getEditorialId());
        book.setEditorial(editorial);



        return book;
    }



}
