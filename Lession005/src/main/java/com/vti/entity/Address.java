package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", length = 100, nullable = false)
    private String Street;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

//    @OneToOne(mappedBy = "address")
//    private Account account;

    @OneToMany(mappedBy = "address")
    private List<Account> accounts;

//    @ManyToMany(mappedBy = "addresses")
//    private List<Account> accounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
