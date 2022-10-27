package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.AuthorRequest;
import com.library.demo.controllers.dtos.responses.AuthorResponse;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Author;
import com.library.demo.repositories.IAuthorRepository;
import com.library.demo.services.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorRepository repository;


    @Override
    public Author findAuthorById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró"));
    }

    @Override
    public Author findAuthorByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new RuntimeException("No se encontró"));
    }

    @Override
    public AuthorResponse create(AuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        Author savedAuthor = repository.save(author);
        return from(savedAuthor);
    }

    private AuthorResponse from(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }
}
