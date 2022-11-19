package com.bookstore.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CommentResponse {

    private Long id;

    private String userName;

    private String bookName;

    private String content;

    private LocalDate date;
}
