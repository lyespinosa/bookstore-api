package com.library.demo.entities;

import com.library.demo.entities.pivots.BookGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "genders")
@Getter @Setter
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<BookGender> bookGenders;
}
