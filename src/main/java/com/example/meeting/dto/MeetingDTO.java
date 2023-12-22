package com.example.meeting.dto;

import com.example.meeting.exception.InvalidLocalDateTimeException;
import com.example.meeting.exception.InvalidTitleException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeetingDTO {
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    private LocalDateTime localDateTime;

    public String getTitle() {
        if (title == null || title.isEmpty()) {
            throw new InvalidTitleException();
        }
        return title;
    }

    public LocalDateTime getLocalDateTime() {
        if (localDateTime == null || localDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidLocalDateTimeException();
        }
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTimeInString) {
        this.localDateTime = LocalDateTime.parse(localDateTimeInString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
