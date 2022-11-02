package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class CreateBookRequest {

    private String cover;

    @NotBlank
    private String description;

    private String name;

    private BigDecimal price;

    private String year;

    private Long authorId;

    private Long editorialId;

    private List<Long> genders;

}
