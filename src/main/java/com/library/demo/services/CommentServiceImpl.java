package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.CreateCommentRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.CommentResponse;
import com.library.demo.entities.Book;
import com.library.demo.entities.Comment;
import com.library.demo.entities.User;
import com.library.demo.entities.projections.CommentProjection;
import com.library.demo.repositories.ICommentRepository;
import com.library.demo.services.interfaces.IBookService;
import com.library.demo.services.interfaces.ICommentService;
import com.library.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository repository;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @Override
    public BaseResponse listAllCommentsByBookId(Long id) {
        List<CommentResponse> response = repository.listAllCommentsByBookId(id).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("All book comments")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment = from(request, comment);
        CommentResponse response = from(repository.save(comment));

        return BaseResponse.builder()
                .data(response)
                .message("Comment added")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    private CommentResponse from(Comment comment) {
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setUserName(comment.getUser().getUserName());
        response.setBookName(comment.getBook().getName());
        response.setContent(comment.getContent());
        response.setDate(comment.getDate());
        return response;
    }

    private CommentResponse from(CommentProjection comment){
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setUserName(comment.getUserName());
        response.setBookName(comment.getBookName());
        response.setContent(comment.getContent());
        response.setDate(comment.getDate());
        return response;
    }

    private Comment from(CreateCommentRequest request, Comment comment){

        User user = userService.findUserById(request.getUserId());
        comment.setUser(user);

        Book book = bookService.findBookById(request.getBookId());
        comment.setBook(book);

        comment.setContent(request.getContent());
        comment.setDate(request.getDate());
        return comment;
    }
}
