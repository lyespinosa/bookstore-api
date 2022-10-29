package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.GenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Gender;

import java.util.List;

public interface IGenderService {

    Gender findGenderById(Long id);

    List<Gender> findEGenderByName(String name);

    BaseResponse listGenders();

    BaseResponse getGenderById(Long id);

    BaseResponse getGenderByName(String name);

    BaseResponse create(GenderRequest request);

    BaseResponse update(Long id,GenderRequest request);

    void delete(Long id);

}
