package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CommentRequest {

    private String content;

    private LocalDate date;
}
