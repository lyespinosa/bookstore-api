package com.library.demo.entities;

import com.library.demo.entities.pivots.AuthorBook;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="books")
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "book")
    private List<AuthorBook> authorBooks;

    private String description;

    private Date year   ;

    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<Order> orders;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;
}
