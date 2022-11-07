package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter @Getter
public class CreateOrderRequest {


    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    @Positive
    private int quantity;

    @NotNull @PastOrPresent
    private LocalDate orderDate;

    @NotNull @FutureOrPresent
    private LocalDate deliveryDate;

    @NotNull @NotBlank
    private String status;
}
