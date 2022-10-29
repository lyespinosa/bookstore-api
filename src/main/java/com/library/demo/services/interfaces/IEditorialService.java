package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.EditorialRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Editorial;

import java.util.List;

public interface IEditorialService {

    Editorial findEditorialById(Long id);

    List<Editorial> findEditorialByName(String name);

    BaseResponse listEditorials();

    BaseResponse getEditorialById(Long id);

    BaseResponse getEditorialByName(String name);

    BaseResponse create(EditorialRequest request);

    BaseResponse update(Long id,EditorialRequest request);

    void delete(Long id);


}
