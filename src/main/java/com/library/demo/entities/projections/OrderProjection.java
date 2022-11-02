package com.library.demo.entities.projections;

import java.math.BigDecimal;

public interface OrderProjection {
    Long getId();

    Long getUserId();

    Long getBookId();

    BigDecimal getPrice();

    int getQuantity();

    BigDecimal getTotal();

    String getStatus();

}
