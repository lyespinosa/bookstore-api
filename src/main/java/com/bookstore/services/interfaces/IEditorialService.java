package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Editorial;
import com.bookstore.controllers.dtos.requests.CreateEditorialRequest;
import com.bookstore.controllers.dtos.requests.UpdateEditorialRequest;

import java.util.List;

public interface IEditorialService {

    Editorial findEditorialById(Long id);

    List<Editorial> findEditorialByName(String name);

    BaseResponse listEditorials();

    BaseResponse getEditorialById(Long id);

    BaseResponse getEditorialByName(String name);

    BaseResponse create(CreateEditorialRequest request);

    BaseResponse update(Long id, UpdateEditorialRequest request);

    void delete(Long id);


}
