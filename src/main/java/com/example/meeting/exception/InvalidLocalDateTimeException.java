package com.example.meeting.exception;

public class InvalidLocalDateTimeException extends RuntimeException {
    public InvalidLocalDateTimeException(String message) {
        super(message);
    }

    public InvalidLocalDateTimeException() {

    }
}
