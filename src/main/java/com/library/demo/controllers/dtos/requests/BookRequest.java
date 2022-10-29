package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter @Setter
public class BookRequest {

    private String cover;

    @NotBlank
    private String description;

    private String name;

    private BigDecimal price;

    private String year;

    private Long authorId;

    private Long editorialId;

}
