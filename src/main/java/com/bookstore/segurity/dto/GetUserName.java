package com.bookstore.segurity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class GetUserName {

    @NotBlank
    private String userName;

}
