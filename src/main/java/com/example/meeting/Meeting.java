package com.example.meeting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class Meeting implements Comparable<Meeting> {
    private String title;
    private String description;
    private LocalDateTime localDateTime;

    @Override
    public int compareTo(Meeting other) {
        return localDateTime.compareTo(other.localDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return this.localDateTime.equals(((Meeting) o).localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(localDateTime);
    }
}
