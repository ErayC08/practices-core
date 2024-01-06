package com.example.meeting.controller;

import com.example.meeting.exception.InvalidDateTimeException;
import com.example.meeting.exception.InvalidTitleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeetingRestControllerAdvice {

    @ExceptionHandler({InvalidTitleException.class, InvalidDateTimeException.class})
    public String handleBadRequest(RuntimeException e) {
        return e.getLocalizedMessage();
    }
}
