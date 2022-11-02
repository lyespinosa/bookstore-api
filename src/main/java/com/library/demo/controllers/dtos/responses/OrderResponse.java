package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class OrderResponse {

    private Long id;

    private Long bookId;

    private Long userId;

    private BigDecimal price;

    private int quantity;

    private BigDecimal total;

    private String status;
}
