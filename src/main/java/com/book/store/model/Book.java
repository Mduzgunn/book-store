package com.book.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;

    private Double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "author_id"))
    private Author author;

    public Book(String id,String title, Double cost, Author author) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.author = author;
    }

    public Book(String title, Double cost, Author author) {
        this.title = title;
        this.cost = cost;
        this.author = author;

    }

    public Book() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
