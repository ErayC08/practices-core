package com.example.meeting.controller;

import com.example.meeting.Meeting;
import com.example.meeting.service.MeetingNotificationService;
import com.example.meeting.service.MeetingService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/meetings")
public class MeetingRestController {
    private final MeetingService meetingService;
    private final ScheduledExecutorService scheduledExecutorService;

    public MeetingRestController(MeetingService meetingService) {
        this.meetingService = meetingService;
        this.scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        this.scheduledExecutorService.scheduleWithFixedDelay(new MeetingNotificationService(this.meetingService), 0, 20L, TimeUnit.SECONDS);
    }

    @GetMapping()
    public TreeSet<Meeting> meetings() {
        return this.meetingService.meetings();
    }

    @GetMapping("/pending-meetings")
    public TreeSet<Meeting> pendingMeetings() {
        return this.meetingService.pendingMeetings();
    }

    @GetMapping("/next")
    public Meeting nextMeeting() {
        return this.meetingService.nextMeeting();
    }

    @PostMapping
    public boolean add(@RequestBody Meeting meeting) {
        return this.meetingService.add(meeting);
    }

    @DeleteMapping("/{dateTime}")
    public boolean remove(@PathVariable LocalDateTime dateTime) {
        return this.meetingService.remove(dateTime);
    }
}
