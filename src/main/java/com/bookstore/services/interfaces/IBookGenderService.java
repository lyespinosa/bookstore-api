package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.BookResponse;
import com.bookstore.controllers.dtos.responses.GenderResponse;
import com.bookstore.entities.pivots.BookGender;
import com.bookstore.controllers.dtos.requests.CreateBookGenderRequest;

import java.util.List;

public interface IBookGenderService {

    BaseResponse listBookGenders();

    BookGender findBookGenderById(Long id);

    List<GenderResponse> listAllGendersByBookId(Long id);

    List<BookResponse> listAllBooksByGenderId(Long id);

    BaseResponse create(CreateBookGenderRequest request);

    void delete(Long id);

}
