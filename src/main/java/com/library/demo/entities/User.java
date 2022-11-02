package com.library.demo.entities;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
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

    private String userName;

    private String email;

    private String password;

    private LocalDate birth;

    @Column(length = 10)
    private String phoneNumber;

    private String address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
