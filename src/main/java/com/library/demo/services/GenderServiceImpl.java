package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.GenderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.GenderResponse;
import com.library.demo.controllers.exceptions.BookException;
import com.library.demo.entities.Gender;
import com.library.demo.repositories.IGenderRepository;
import com.library.demo.services.interfaces.IGenderService;
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
        return repository.findById(id).orElseThrow(() -> new BookException("No se encontró"));
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
    public BaseResponse create(GenderRequest request) {
        Gender gender = new Gender();
        gender = from(request, gender);
        GenderResponse response= from(repository.save(gender));
        return BaseResponse.builder()
                .data(response)
                .message("Gender created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, GenderRequest request) {
        Gender gender = new Gender();
        gender = from(request, gender);
        GenderResponse response = from(repository.save(gender));
        return BaseResponse.builder()
                .data(response)
                .message("Gender updated")
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GenderResponse from(Gender gender){
        GenderResponse response = new GenderResponse();
        response.setId(gender.getId());
        response.setName(gender.getName());
        return response;
    }

    private Gender from(GenderRequest request, Gender gender){
        gender.setName(request.getName());
        return gender;
    }

}
