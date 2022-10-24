package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter @Setter
public class BookResponse {

    private Long id;

    private String name;

    private String description;

    private String authorName;

    private String editorialName;

    private String year;

    private BigDecimal price;



}
