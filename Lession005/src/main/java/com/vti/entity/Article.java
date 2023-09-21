package com.vti.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Article")
public class Article {
//    public Article(int id, String title, String type, Status status) {
//        this.id = id;
//        this.title = title;
//        this.type = type;
//        this.status = status;
//    }
    public Article() {

    }

    public Article(String title, String type, Status status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.status = status;
    }

//    @Column(name="id")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Column(name="type", length = 50, nullable = false)
    private String type;

//    @Column(name="status")
//    @Enumerated(EnumType.STRING)
//    private Status status;

    @Column(name="status", columnDefinition = "enum('OPEN', 'REVIEW', 'APPROVED', 'REJECT')")
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        OPEN, REVIEW, APPROVED, REJECT;
    }

    @Override
    public String toString() {
        return "[id=" + id + "; title=" + title + "; type=" + type + "; status=" + status + "]";
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
