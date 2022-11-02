package com.library.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class CreateOrderRequest {

    private Long id;

    private Long bookId;

    private Long userId;

    private int quantity;

    private String status;
}
