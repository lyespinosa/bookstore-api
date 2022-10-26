package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class BookRequest {

    private String name;

    private String description;

    private String cover;

    private String authorName;

    private String EditorialName;

    private String gender;

    private String year;

    private BigDecimal price;


}
