package com.bookstore.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class UpdateStatusRequest {

    @NotNull @NotBlank
    private String name;
}
