package com.book.store.dto.request;

import java.io.Serializable;

public class CreateBookRequest implements Serializable {
    String title;
    Double cost;

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
}
