package com.book.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;
    private Double cost;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "author_id"))
    @JsonIgnoreProperties(value = {"addresses"})
    private List<Author> authors;

    public Book(String id,String title, Double cost, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.authors = authors;
    }

    public Book(String title, Double cost) {
        this.title = title;
        this.cost = cost;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

}
