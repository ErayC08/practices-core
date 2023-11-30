package com.example.factory.exception;

public class ColorNotFoundException extends RuntimeException {
    public ColorNotFoundException(String message) {
        super(message);
    }
}
