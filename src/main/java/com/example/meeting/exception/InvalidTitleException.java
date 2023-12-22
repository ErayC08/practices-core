package com.example.meeting.exception;

public class InvalidTitleException extends RuntimeException {
    public InvalidTitleException(String message) {
        super(message);
    }

    public InvalidTitleException() {

    }
}
