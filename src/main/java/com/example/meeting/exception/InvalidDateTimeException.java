package com.example.meeting.exception;

public class InvalidDateTimeException extends RuntimeException {
    public InvalidDateTimeException() {
        super("The meeting date is missing or past, or it doesn't match with the format 'yyyy-MM-dd HH:mm'.");
    }
}
