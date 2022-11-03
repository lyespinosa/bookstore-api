package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter @Getter
public class CreateOrderRequest {


    @NotNull @NotBlank
    private Long bookId;

    @NotNull @NotBlank
    private Long userId;

    @NegativeOrZero
    private int quantity;

    @NotNull @NotBlank
    private String status;
}
