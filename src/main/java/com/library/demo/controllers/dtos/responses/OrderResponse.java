package com.library.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter @Getter
public class OrderResponse {

    private Long id;

    private Long bookId;

    private Long userId;

    private BigDecimal price;

    private int quantity;

    private BigDecimal total;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private String status;
}
