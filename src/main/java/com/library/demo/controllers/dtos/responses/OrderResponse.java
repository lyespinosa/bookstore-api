package com.library.demo.controllers.dtos.responses;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class OrderResponse {

    private Long id;

    private Long bookId;

    private Long userId;

    private int quantity;

    private BigDecimal total;

    private String status;
}
