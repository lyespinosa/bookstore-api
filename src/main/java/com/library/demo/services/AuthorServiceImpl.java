package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateAuthorRequest;
import com.library.demo.controllers.dtos.requests.UpdateAuthorRequest;
import com.library.demo.controllers.dtos.responses.AuthorResponse;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.exceptions.BookException;
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
        return repository.findById(id).orElseThrow(() -> new BookException("Author not found "));
    }

    @Override
    public List<Author> findAuthorByName(String name) {
            return repository.getAuthorByName(name);
    }

    @Override
    public BaseResponse listAuthors() {
        List<AuthorResponse> responses = repository.findAll().stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Authors list")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAuthorById(Long id) {
        AuthorResponse response = from(findAuthorById(id));
        return BaseResponse.builder()
                .data(response)
                .message("Author by Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAuthorByName(String name) {
        List<AuthorResponse> responses = findAuthorByName(name).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("Authors filter by name")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateAuthorRequest request) {
        Author author = new Author();
        author = create(request, author);
        AuthorResponse response = from(repository.save(author));
        return BaseResponse.builder()
                .data(response)
                .message("Author created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    @Override
    public BaseResponse update(Long id, UpdateAuthorRequest request) {
        Author author = findAuthorById(id);
        author = update(request, author);
        AuthorResponse response = from(repository.save(author));
        return BaseResponse.builder()
                .data(response)
                .message("Author updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    private AuthorResponse from(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }

    private Author create(CreateAuthorRequest request, Author author){
        author.setName(request.getName());
        return author;
    }

    private Author update(UpdateAuthorRequest request, Author author){
        author.setName(request.getName());
        return author;
    }
}
