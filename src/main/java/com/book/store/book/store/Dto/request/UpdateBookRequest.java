package com.book.store.book.store.Dto.request;

import com.book.store.book.store.Model.Author;

import java.util.List;

public class UpdateBookRequest {

    Long id;
    String title;
    Double cost;

    List<String> authorIdList;

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

    public List<String> getAuthorIdList() {
        return authorIdList;
    }

    public void setAuthorIdList(List<String> authorIdList) {
        this.authorIdList = authorIdList;
    }
}
