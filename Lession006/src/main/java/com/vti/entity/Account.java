package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Account")
public class Account {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name="password", length = 50, nullable = false)
    private String password;

    @Column(name="first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name="last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name="role", columnDefinition = "enum('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @Enumerated(EnumType.STRING)
    private AccountRole role;

//    @OneToOne
//    @JoinColumn(name="address_id", referencedColumnName = "id")
//    private Address address;

    @ManyToOne
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;

//    @ManyToMany
//    @JoinTable(
//            name = "account_group",
//            joinColumns = @JoinColumn(name = "group_id"),
//            inverseJoinColumns = @JoinColumn(name = "account_id")
//    )
//    private List<Group> groups;

    @OneToMany(mappedBy = "creator")
    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
//    @ManyToMany
//    @JoinTable(
//            name = "account_address",
//            joinColumns = @JoinColumn(name = "address_id"),
//            inverseJoinColumns = @JoinColumn(name = "account_id")
//    )
//    private List<Address> addresses;

    public enum AccountRole {
        ADMIN, EMPLOYEE, MANAGER
    }

    public Account() {

    }

    public Account(String username,
                   String password,
                   String firstName,
                   String lastName,
                   AccountRole role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountRole getRole() {
        return role;
    }

    public void setRole(AccountRole role) {
        this.role = role;
    }

}
