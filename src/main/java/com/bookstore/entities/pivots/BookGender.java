package com.bookstore.entities.pivots;


import com.bookstore.entities.Book;
import com.bookstore.entities.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "books_genders")
@Setter @Getter
public class BookGender  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Gender gender;

}
