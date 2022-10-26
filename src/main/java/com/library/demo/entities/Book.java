package com.library.demo.entities;

import com.library.demo.entities.pivots.BookGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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

    private String description;

    @Column(length = 400)
    private String cover;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;


    @ManyToOne
    @JoinColumn(name = "editorial_id", referencedColumnName = "id")
    private Editorial editorial;


    private String year;

    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<BookGender> bookGenders;

    @OneToMany(mappedBy = "book")
    private List<Order> orders;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

    //Hola
}
