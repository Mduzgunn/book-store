package com.book.store.dto.request;

import com.book.store.model.Book;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UpdateAuthorRequest {
    @NotNull
    private String email;

    private String phone;

    private List<Book> books;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
