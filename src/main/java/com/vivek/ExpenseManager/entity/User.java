package com.vivek.ExpenseManager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "users") // Change table name to "users"
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


}
