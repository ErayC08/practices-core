package com.example.meeting;

import com.example.meeting.exception.InvalidDateTimeException;
import com.example.meeting.exception.InvalidTitleException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class Meeting implements Comparable<Meeting> {
    private String title;
    private String description;
    private LocalDateTime dateTime;

    public Meeting(String title, String description, LocalDateTime dateTime) {
        setTitle(title);
        setDescription(description);
        setDateTime(dateTime);
    }

    public Meeting() {}

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() < 3) {
            throw new InvalidTitleException();
        }
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null || dateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidDateTimeException();
        }
        this.dateTime = dateTime;
    }

    @JsonIgnore
    public boolean isPending() {
        return !this.dateTime.isBefore(LocalDateTime.now());
    }

    @Override
    public int compareTo(Meeting other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Meeting other = (Meeting) o;

        return this.dateTime.equals(other.dateTime);
    }

    @Override
    public int hashCode() {
        return this.dateTime.hashCode();
    }

    public static Meeting pseudoMeeting(String title, String description, LocalDateTime dateTime) {
        Meeting meeting = new Meeting();

        meeting.title = title;
        meeting.description = description;
        meeting.dateTime = dateTime;

        return meeting;
    }
}
