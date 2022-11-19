package com.bookstore.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
;
import java.util.List;

@Entity
@Table(name="authors")
@Getter@Setter
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;


}
