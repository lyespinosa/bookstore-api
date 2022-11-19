package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Gender;
import com.bookstore.controllers.dtos.requests.CreateGenderRequest;
import com.bookstore.controllers.dtos.requests.UpdateGenderRequest;

import java.util.List;

public interface IGenderService {

    Gender findGenderById(Long id);

    List<Gender> findGenderListById(List<Long> ids);

    List<Gender> findEGenderByName(String name);

    BaseResponse listGenders();

    BaseResponse getGenderById(Long id);

    BaseResponse getGenderByName(String name);

    BaseResponse create(CreateGenderRequest request);

    BaseResponse update(Long id, UpdateGenderRequest request);

    void delete(Long id);

}
