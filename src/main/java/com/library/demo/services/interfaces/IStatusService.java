package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateStatusRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Status;

public interface IStatusService {
    Status findStatusById(Long id);

    Status findStatusByName(String name);

    BaseResponse listStatus();

    BaseResponse getStatusById(Long id);

    BaseResponse getStatusByName(String name);

    BaseResponse create(CreateStatusRequest request);


}
