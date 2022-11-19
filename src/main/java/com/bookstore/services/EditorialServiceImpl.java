package com.bookstore.services;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.EditorialResponse;
import com.bookstore.controllers.exceptions.BookException;
import com.bookstore.entities.Editorial;
import com.bookstore.repositories.IEditorialRepository;
import com.bookstore.controllers.dtos.requests.CreateEditorialRequest;
import com.bookstore.controllers.dtos.requests.UpdateEditorialRequest;
import com.bookstore.services.interfaces.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialServiceImpl implements IEditorialService {

    @Autowired
    private IEditorialRepository repository;


    @Override
    public Editorial findEditorialById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("Editorial not found"));
    }

    @Override
    public List<Editorial> findEditorialByName(String name) {
        return repository.getEditorialByName(name);
    }

    @Override
    public BaseResponse listEditorials() {
        List<EditorialResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Editorials list")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getEditorialById(Long id) {
        EditorialResponse response = from(findEditorialById(id));
        return BaseResponse.builder()
                .data(response)
                .message("Editorial order by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getEditorialByName(String name) {
        List<EditorialResponse> responses = findEditorialByName(name).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Editorials filter by name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateEditorialRequest request) {
        Editorial editorial = new Editorial();
        editorial = create(request, editorial);
        EditorialResponse response = from(repository.save(editorial));
        return BaseResponse.builder()
                .data(response)
                .message("Editorial created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    @Override
    public BaseResponse update(Long id, UpdateEditorialRequest request) {
        Editorial editorial = findEditorialById(id);
        editorial = update(request, editorial);
        EditorialResponse response = from(repository.save(editorial));
        return BaseResponse.builder()
                .data(response)
                .message("Editorial updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        findEditorialById(id);
        repository.deleteById(id);
    }

    private EditorialResponse from(Editorial editorial){
        EditorialResponse response = new EditorialResponse();
        response.setId(editorial.getId());
        response.setName(editorial.getName());
        return response;
    }

    private Editorial create(CreateEditorialRequest request, Editorial editorial){
        editorial.setName(request.getName());
        return editorial;
    }

    private Editorial update(UpdateEditorialRequest request, Editorial editorial){
        editorial.setName(request.getName());
        return editorial;
    }
}
