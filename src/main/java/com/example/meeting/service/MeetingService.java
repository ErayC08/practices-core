package com.example.meeting.service;

import com.example.meeting.Meeting;

import java.util.TreeSet;

public class MeetingService {
    private final TreeSet<Meeting> meetings;

    public MeetingService(TreeSet<Meeting> meetings) {
        this.meetings = meetings;
    }

    public MeetingService() {
        this(new TreeSet<>());
    }

    public boolean add(Meeting meeting) {
        return meetings.add(meeting);
    }

    public boolean remove(Meeting meeting) {
        return meetings.remove(meeting);
    }

    protected final TreeSet<Meeting> getMeetings() {
        return meetings;
    }
}
