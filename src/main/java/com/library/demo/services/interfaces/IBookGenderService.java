package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.BookGenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.controllers.dtos.responses.GenderResponse;

import java.util.List;

public interface IBookGenderService {

    List<GenderResponse> listAllGendersByBookId(Long id);

    List<BookResponse> listAllBooksByGenderId(Long id);

    BaseResponse create(BookGenderRequest request);

}
