package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter @Getter
public class UpdateBookGenderRequest {

    @NotNull
    private Long bookId;

    @NotNull
    private Long genderId;
}
