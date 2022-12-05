package com.bookstore.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter @Getter
public class CreateUserRequest {

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    private String userName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull @Past
    private LocalDate birth;

    @Size(min = 10,max = 14)
    private String phoneNumber;


    private String address;

    private Boolean admin;
}
