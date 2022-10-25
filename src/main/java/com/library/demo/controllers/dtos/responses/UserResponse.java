package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
public class UserResponse {

    private Long id;

    private String name;

    private String lastName;

    private String userName;

    private String email;

    private LocalDate birth;

    private String address;

}
