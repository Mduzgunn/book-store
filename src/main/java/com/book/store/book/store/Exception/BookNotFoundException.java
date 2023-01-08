package com.book.store.book.store.Exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (String s){
        super(s);
    }
}
