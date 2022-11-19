package com.bookstore.controllers.exceptions;

public class BookException extends RuntimeException{

    public BookException(String message) {
        super(message);
    }
}
