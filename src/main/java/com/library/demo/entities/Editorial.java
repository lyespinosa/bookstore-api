package com.library.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "editorials")
@Getter @Setter
public class Editorial {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Book> books;
}
