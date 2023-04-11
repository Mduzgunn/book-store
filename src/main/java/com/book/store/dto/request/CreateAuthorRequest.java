package com.book.store.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class CreateAuthorRequest implements Serializable {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

}
