package com.library.demo.entities.projections;

import java.util.Date;

public interface CommentProjection {

    Long getId();

    String getContent();

    Date getDate();
}
