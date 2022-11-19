package com.bookstore.entities.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface OrderProjection {
    Long getId();

    Long getUserId();

    Long getBookId();

    BigDecimal getPrice();

    int getQuantity();

    BigDecimal getTotal();

    LocalDate getOrderDate();

    LocalDate getDeliveryDate();

    String getStatusName();

}
