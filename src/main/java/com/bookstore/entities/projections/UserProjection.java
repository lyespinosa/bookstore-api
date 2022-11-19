package com.bookstore.entities.projections;

import java.time.LocalDate;

public interface UserProjection {

    Long getId();

    String getName();

    String getLastName();

    String getUserName();

    String getEmail();

    LocalDate getBirth();

    String getAddress();
}
