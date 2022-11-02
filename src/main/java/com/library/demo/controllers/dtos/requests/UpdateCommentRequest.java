package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class UpdateCommentRequest {

    private Long userId;

    private Long bookId;

    @NotBlank @NotNull
    private String content;

    private LocalDate date;
}
