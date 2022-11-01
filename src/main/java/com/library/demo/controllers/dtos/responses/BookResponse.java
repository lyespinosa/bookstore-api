package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class BookResponse {

    private Long id;

    private String name;

    private String description;

    private String cover;

    private String authorName;

    private String editorialName;
    
    private String year;

    private BigDecimal price;



}
