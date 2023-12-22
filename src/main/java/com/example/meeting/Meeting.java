package com.example.meeting;

import com.example.meeting.exception.InvalidLocalDateTimeException;
import com.example.meeting.exception.InvalidTitleException;

import java.time.LocalDateTime;

public class Meeting implements Comparable<Meeting> {
    private String title;
    private String description;
    private LocalDateTime localDateTime;

    public Meeting(String title, String description, LocalDateTime localDateTime) {
        setTitle(title);
        setDescription(description);
        setLocalDateTime(localDateTime);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new InvalidTitleException();
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null || localDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidLocalDateTimeException();
        }
        this.localDateTime = localDateTime;
    }

    @Override
    public int compareTo(Meeting other) {
        return localDateTime.compareTo(other.localDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meeting other = (Meeting) o;

        return localDateTime.equals(other.localDateTime);
    }

    @Override
    public int hashCode() {
        return localDateTime.hashCode();
    }

    public boolean isPast() {
        return localDateTime.isBefore(LocalDateTime.now());
    }
}
