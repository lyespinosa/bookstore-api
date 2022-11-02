package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter @Getter
public class CreateUserRequest {

    private String name;

    private String lastName;

    private String userName;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull @NotBlank @Pattern(regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$")
    private LocalDate birth;

    @Size(min = 10,max = 14)
    private String phoneNumber;


    private String address;
}
