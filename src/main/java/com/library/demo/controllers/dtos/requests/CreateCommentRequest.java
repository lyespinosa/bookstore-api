package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class CreateCommentRequest {

    @NotBlank @NotNull
    private String content;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;




}
