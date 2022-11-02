package com.library.demo.entities.projections;

import java.math.BigDecimal;

public interface OrderProjection {

    Long getId();

    Long getUserId();

    Long getBookId();

    BigDecimal getTotal();

    int getQuantity();

    String getStatus();

}
