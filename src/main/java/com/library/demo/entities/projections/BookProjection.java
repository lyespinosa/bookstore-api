package com.library.demo.entities.projections;

import java.math.BigDecimal;
import java.time.LocalTime;

public interface BookProjection {

    Long getId();

    String getName();

    String getDescription();

    String getCover();
    String getAuthorName();

    String getEditorialName();

    String getYear();

    BigDecimal getPrice();

    //future leo, if you ask yourself why you don't put the order and the comment
    //relation,it's 'cause you don't must to show it here, that is done on their entities
    //future leo, javi is a dummy and he can´t finish his part :)
}
