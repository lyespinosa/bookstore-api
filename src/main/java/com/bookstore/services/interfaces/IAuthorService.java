package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.requests.CreateAuthorRequest;
import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Author;
import com.bookstore.controllers.dtos.requests.UpdateAuthorRequest;

import java.util.List;

public interface IAuthorService {

    Author findAuthorById(Long id);

    List<Author> findAuthorByName(String name);

    BaseResponse listAuthors();

    BaseResponse getAuthorById(Long id);

    BaseResponse getAuthorByName(String name);

    BaseResponse create(CreateAuthorRequest request);

    BaseResponse update(Long id, UpdateAuthorRequest request);

    void delete(Long id);



}
