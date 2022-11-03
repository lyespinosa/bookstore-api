package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateStatusRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.StatusResponse;
import com.library.demo.controllers.exceptions.BookException;
import com.library.demo.entities.Status;
import com.library.demo.repositories.IStatusRepository;
import com.library.demo.services.interfaces.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements IStatusService {

    @Autowired
    private IStatusRepository repository;

    @Override
    public Status findStatusById(Long id) {
        return repository.findById(id).orElseThrow( () -> new BookException("Status not found"));
    }

    @Override
    public Status findStatusByName(String name) {
        Status status = repository.getStatusByName(name);

        if(status == null){
            throw new BookException("That Status does not exist");
        }

        return status;
    }

    @Override
    public BaseResponse listStatus() {
        List<StatusResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("All types of status")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getStatusById(Long id) {
        StatusResponse response = from(findStatusById(id));
        return BaseResponse.builder()
                .data(response)
                .message("Status by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getStatusByName(String name) {
        StatusResponse response = from(findStatusByName(name));
        return BaseResponse.builder()
                .data(response)
                .message("Status by name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateStatusRequest request) {
        Status status = new Status();
        status = from(request,status);
        StatusResponse response = from(repository.save(status));
        return BaseResponse.builder()
                .data(response)
                .message("Status created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }



    private StatusResponse from(Status status){
        StatusResponse response = new StatusResponse();
        response.setId(status.getId());
        response.setName(status.getName());
        return response;
    }

    private Status from(CreateStatusRequest request, Status status){
        status.setName(request.getName());
        return status;
    }
}
