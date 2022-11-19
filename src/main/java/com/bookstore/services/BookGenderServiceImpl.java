package com.bookstore.services;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.BookGenderResponse;
import com.bookstore.controllers.dtos.responses.GenderResponse;
import com.bookstore.controllers.exceptions.BookException;
import com.bookstore.entities.Book;
import com.bookstore.entities.Gender;
import com.bookstore.entities.pivots.BookGender;
import com.bookstore.entities.projections.BookProjection;
import com.bookstore.entities.projections.GenderProjection;
import com.bookstore.repositories.IBooksGenderRepository;
import com.bookstore.controllers.dtos.requests.CreateBookGenderRequest;
import com.bookstore.controllers.dtos.responses.BookResponse;
import com.bookstore.services.interfaces.IBookGenderService;
import com.bookstore.services.interfaces.IBookService;
import com.bookstore.services.interfaces.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookGenderServiceImpl implements IBookGenderService {

    @Autowired
    private IBooksGenderRepository repository;

    @Autowired
    private IGenderService genderService;

    @Autowired
    private IBookService bookService;

    @Override
    public BaseResponse listBookGenders() {
        List<BookGenderResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Books_Genders relations listed")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BookGender findBookGenderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("BookGender relation not found "));
    }

    @Override
    public List<GenderResponse> listAllGendersByBookId(Long id) {
        List<GenderProjection> genders = repository.listAllGendersByBookId(id);
        return genders.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> listAllBooksByGenderId(Long id) {
        List<BookProjection> books = repository.listAllBooksByGenderId(id);
        return books.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public BaseResponse create(CreateBookGenderRequest request) {
        BookGender bookGender = new BookGender();
        bookGender = from(request, bookGender);
        BookGenderResponse response = from(repository.save(bookGender));
        return BaseResponse.builder()
                .data(response)
                .message("relation created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public void delete(Long id) {
        findBookGenderById(id);
        repository.deleteById(id);
    }


    private GenderResponse from(GenderProjection gender){
        GenderResponse response = new GenderResponse();
        response.setId(gender.getId());
        response.setName(gender.getName());
        return response;
    }

    private BookResponse from(BookProjection book){
        BookResponse bookResponse =  bookService.from(book);
        return bookResponse;

    }

    private BookGenderResponse from(BookGender bookGender){
        BookGenderResponse response = new BookGenderResponse();
        response.setId(bookGender.getId());
        response.setBookName( bookGender.getBook().getName() );
        response.setGenderName( bookGender.getGender().getName() );

        return  response;
    }

    private BookGender from(CreateBookGenderRequest request, BookGender bookGender){

        Gender gender = genderService.findGenderById(request.getGenderId());
        bookGender.setGender(gender);

        Book book = bookService.findBookById(request.getBookId());
        bookGender.setBook(book);

        return bookGender;
    }
}
