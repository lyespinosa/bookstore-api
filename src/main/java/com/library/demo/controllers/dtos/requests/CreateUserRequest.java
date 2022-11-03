package com.library.demo.controllers.dtos.requests;

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

    @NotNull @Email
    private String email;

    @NotNull @NotBlank @Pattern(regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$")
    private String password;

    @NotNull
    private LocalDate birth;

    @Size(min = 10,max = 14)
    private String phoneNumber;


    private String address;
}
