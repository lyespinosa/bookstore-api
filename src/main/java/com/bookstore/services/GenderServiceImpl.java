package com.bookstore.services;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.GenderResponse;
import com.bookstore.controllers.exceptions.BookException;
import com.bookstore.entities.Gender;
import com.bookstore.repositories.IGenderRepository;
import com.bookstore.controllers.dtos.requests.CreateGenderRequest;
import com.bookstore.controllers.dtos.requests.UpdateGenderRequest;
import com.bookstore.services.interfaces.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements IGenderService {

    @Autowired
    IGenderRepository repository;



    @Override
    public Gender findGenderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("Gender not found"));
    }

    @Override
    public List<Gender> findGenderListById(List<Long> ids) {
        return null;
    }

    @Override
    public List<Gender> findEGenderByName(String name) {
        return repository.getGenderByName(name);
    }

    @Override
    public BaseResponse listGenders() {
        List<GenderResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Genders list")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getGenderById(Long id) {
        GenderResponse response = from(findGenderById(id));
        return BaseResponse.builder()
                .data(response)
                .message("Genders order by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getGenderByName(String name) {
        List<GenderResponse> responses = findEGenderByName(name).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Genders filter by name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateGenderRequest request) {
        Gender gender = new Gender();
        gender = create(request, gender);
        GenderResponse response= from(repository.save(gender));
        return BaseResponse.builder()
                .data(response)
                .message("Gender created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateGenderRequest request) {
        Gender gender = new Gender();
        gender = update(request, gender);
        GenderResponse response = from(repository.save(gender));
        return BaseResponse.builder()
                .data(response)
                .message("Gender updated")
                .build();
    }

    @Override
    public void delete(Long id) {
        findGenderById(id);
        repository.deleteById(id);
    }

    private GenderResponse from(Gender gender){
        GenderResponse response = new GenderResponse();
        response.setId(gender.getId());
        response.setName(gender.getName());
        return response;
    }

    private Gender create(CreateGenderRequest request, Gender gender){
        gender.setName(request.getName());
        return gender;
    }

    private Gender update(UpdateGenderRequest request, Gender gender){
        gender.setName(request.getName());
        return gender;
    }

}
