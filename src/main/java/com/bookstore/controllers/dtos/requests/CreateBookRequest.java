package com.bookstore.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class CreateBookRequest {
    @NotNull @NotBlank
    private String cover;

    @NotNull
    private String description;

    @NotNull @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull @NotBlank
    private String year;

    @NotNull
    private Long authorId;

    @NotNull
    private Long editorialId;

    private List<Long> genders;

}
