package com.bookstore.entities;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;


    private String password;

    private LocalDate birth;

    @Column(length = 10, unique = true)
    private String phoneNumber;

    private String address;

    private Boolean admin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
