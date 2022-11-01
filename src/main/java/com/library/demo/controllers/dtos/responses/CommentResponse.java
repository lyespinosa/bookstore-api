package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CommentResponse {
    private Long id;

    private String content;

    private LocalDate date;
}
