package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateBookGenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookGenderResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.controllers.dtos.responses.GenderResponse;
import com.library.demo.entities.Book;
import com.library.demo.entities.Gender;
import com.library.demo.entities.pivots.BookGender;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.entities.projections.GenderProjection;
import com.library.demo.repositories.IBooksGenderRepository;
import com.library.demo.services.interfaces.IBookGenderService;
import com.library.demo.services.interfaces.IBookService;
import com.library.demo.services.interfaces.IGenderService;
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
