package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BookGenderResponse {

    private Long id;

    private String bookName;

    private String genderName;
}
