package com.library.demo.entities;


import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalTime;

import javax.persistence.*;
;import java.util.List;

@Entity
@Table(name="authors")
@Getter@Setter
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


}
