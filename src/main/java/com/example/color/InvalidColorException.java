package com.example.color;

public class InvalidColorException extends RuntimeException {
    public InvalidColorException() {
        super("The color is missing, or neither red nor yellow.");
    }
}
