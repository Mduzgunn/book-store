package com.book.store.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException (String s){
        super(s);
    }
}
