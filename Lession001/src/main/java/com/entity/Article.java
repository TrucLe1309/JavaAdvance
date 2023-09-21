package com.entity;



import javax.persistence.*;

@Entity
@Table(name="Article")
public class Article {

    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        OPEN, REVIEW, APPROVED, REJECT;
    }
}

