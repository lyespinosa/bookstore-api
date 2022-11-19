package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Status;
import com.bookstore.controllers.dtos.requests.CreateStatusRequest;

public interface IStatusService {


    Status findStatusById(Long id);

    Status findStatusByName(String name);

    BaseResponse listStatus();

    BaseResponse getStatusById(Long id);

    BaseResponse getStatusByName(String name);

    BaseResponse create(CreateStatusRequest request);

    void delete(Long id);


}
