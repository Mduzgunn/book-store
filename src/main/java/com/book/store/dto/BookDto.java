package com.book.store.dto;

public class BookDto {
    private String id;
    private String title;
    private Double cost;
    private AuthorDto author;

    public BookDto() {}

    public BookDto(String id, String title, Double cost, AuthorDto author)
    {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.author = author;
    }

    public BookDto(String id, String title, Double cost)
    {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

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

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
