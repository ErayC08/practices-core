package com.example.meeting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Meeting implements Comparable<Meeting> {
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    public Meeting(String title, String description, LocalDate date, int hour, int minute) {
        setTitle(title);
        setDescription(description);
        setDate(date);
        setTime(hour, minute);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException("The title is missing, or contains less than three characters.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("The date is missing.");
        }
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(int hour, int minute) {
        this.time = LocalTime.of(hour, minute);
    }

    public boolean isPending() {
        if (date.isAfter(LocalDate.now())) {
            return true;
        }
        if (date.isEqual(LocalDate.now())) {
            return time.isAfter(nowWithoutSeconds());
        }
        return false;
    }

    @Override
    public int compareTo(Meeting other) {
        int dateComparison = date.compareTo(other.date);

        if (dateComparison == 0) {
            return time.compareTo(other.time);
        }
        return dateComparison;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Meeting other = (Meeting) o;

        return date == other.date && time == other.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time);
    }

    private LocalTime nowWithoutSeconds() {
        return LocalTime.parse(LocalTime.now().toString().substring(0, 5));
    }
}
