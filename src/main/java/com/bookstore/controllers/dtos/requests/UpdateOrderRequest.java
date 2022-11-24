package com.bookstore.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter @Setter
public class UpdateOrderRequest {


    @NotNull @NotBlank
    private String status;

    @NotNull @PastOrPresent
    private LocalDate orderDate;

    @NotNull @FutureOrPresent
    private LocalDate deliveryDate;

}
