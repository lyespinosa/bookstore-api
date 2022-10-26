package com.library.demo.entities.projections;

import java.util.Date;
import java.time.LocalDate;


public interface CommentProjection {

    Long getId();

    String getUser();

    String getBook();

    String getContent();

    LocalDate getDate();
}
