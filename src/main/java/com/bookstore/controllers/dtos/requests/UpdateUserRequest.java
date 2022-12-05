package com.bookstore.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter @Getter
public class UpdateUserRequest {

    private String name;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private LocalDate birth;

    private String phoneNumber;

    private String address;
}
