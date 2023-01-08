package com.book.store.book.store.Dto;

public class BookDto {
    private long id;

    private String title;

    private Double cost;

    private long[] authors;

    public BookDto() {}

    public BookDto(long id, String title, Double cost, long[] authors)
    {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.authors = authors;
    }

    public BookDto(long id, String title, Double cost)
    {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long[] getAuthors() {
        return authors;
    }

    public void setAuthors(long[] authors) {
        this.authors = authors;
    }
}
