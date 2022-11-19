package com.bookstore.entities.projections;

import java.util.Date;
import java.time.LocalDate;


public interface CommentProjection {

    Long getId();

    String getUserName();

    String getBookName();

    String getContent();

    LocalDate getDate();
}
