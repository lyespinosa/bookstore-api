package com.library.demo.entities.pivots;

import com.library.demo.entities.Author;
import com.library.demo.entities.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authors_books")
@Getter @Setter
public class AuthorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Book book;
}
