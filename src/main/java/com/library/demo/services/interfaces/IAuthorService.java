package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.AuthorRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Author;

import java.util.List;

public interface IAuthorService {

    Author findAuthorById(Long id);

    List<Author> findAuthorByName(String name);

    BaseResponse listAuthors();

    BaseResponse getAuthorById(Long id);

    BaseResponse getAuthorByName(String name);

    BaseResponse create(AuthorRequest request);

    BaseResponse update(Long id,AuthorRequest request);

    void delete(Long id);



}
