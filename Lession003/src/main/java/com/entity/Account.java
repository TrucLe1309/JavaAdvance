package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "role", columnDefinition = "enum('ADMIN', 'EMPLOYEE','MANAGER')")
    private AccountRole role;

    public enum AccountRole{
        ADMIN, EMPLOYEE, MANAGER
    }



}
