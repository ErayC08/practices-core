package com.example.meeting.service;

import com.example.meeting.Meeting;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    private final TreeSet<Meeting> meetings;

    public MeetingService(TreeSet<Meeting> meetings) {
        this.meetings = meetings;
    }

    public MeetingService() {
        this(new TreeSet<>());
    }

    public TreeSet<Meeting> meetings() {
        return this.meetings;
    }

    public TreeSet<Meeting> pendingMeetings() {
        return this.meetings.stream().filter(Meeting::isPending).collect(Collectors.toCollection(TreeSet::new));
    }

    public Meeting nextMeeting() {
        return this.meetings.higher(Meeting.pseudoMeeting(LocalDateTime.now()));
    }

    public boolean add(Meeting meeting) {
        return this.meetings.add(meeting);
    }

    public boolean remove(LocalDateTime dateTime) {
        return this.meetings.remove(Meeting.pseudoMeeting(dateTime));
    }
}
