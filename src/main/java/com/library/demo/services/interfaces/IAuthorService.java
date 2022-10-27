package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.AuthorRequest;
import com.library.demo.controllers.dtos.responses.AuthorResponse;
import com.library.demo.entities.Author;

public interface IAuthorService {

    Author findAuthorById(Long id);

    Author findAuthorByName(String name);

    AuthorResponse create(AuthorRequest request);
}
