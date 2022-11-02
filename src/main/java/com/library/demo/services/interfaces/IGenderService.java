package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateGenderRequest;
import com.library.demo.controllers.dtos.requests.UpdateGenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Gender;

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
