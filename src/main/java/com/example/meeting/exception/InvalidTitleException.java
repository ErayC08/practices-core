package com.example.meeting.exception;

public class InvalidTitleException extends RuntimeException {

    public InvalidTitleException() {
        super("The title is missing or has less than three characters.");
    }
}
