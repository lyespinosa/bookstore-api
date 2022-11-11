package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateBookGenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.controllers.dtos.responses.GenderResponse;
import com.library.demo.entities.pivots.BookGender;

import java.util.List;

public interface IBookGenderService {

    BaseResponse listBookGenders();

    BookGender findBookGenderById(Long id);

    List<GenderResponse> listAllGendersByBookId(Long id);

    List<BookResponse> listAllBooksByGenderId(Long id);

    BaseResponse create(CreateBookGenderRequest request);

    void delete(Long id);

}
