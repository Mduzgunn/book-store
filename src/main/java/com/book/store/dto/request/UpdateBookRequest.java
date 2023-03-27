package com.book.store.dto.request;

import com.book.store.model.Author;

import java.util.List;

public class UpdateBookRequest {

    Long id;
    String title;
    Double cost;

    List<Author> authorIdList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Author> getAuthorIdList() {
        return authorIdList;
    }

    public void setAuthorIdList(List<Author> authorIdList) {
        this.authorIdList = authorIdList;
    }
}
