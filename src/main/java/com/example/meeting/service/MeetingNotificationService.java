package com.example.meeting.service;

import com.example.meeting.Meeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class MeetingNotificationService implements Runnable {
    private final MeetingService meetingService;
    private static final Logger logger = LoggerFactory.getLogger(MeetingNotificationService.class);

    public MeetingNotificationService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @Override
    public void run() {
        Meeting nextMeeting = this.meetingService.nextMeeting();

        if (nextMeeting != null) {
            String notificationMessage = this.notificationMessage(nextMeeting);

            if (!notificationMessage.isEmpty()) {
                logger.info(notificationMessage);
            }
        }
    }

    protected String notificationMessage(Meeting nextMeeting) {
        long minutesLeft = ChronoUnit.MINUTES.between(LocalDateTime.now(), nextMeeting.getDateTime());

        if (minutesLeft < 5) {
            return "Less than five minutes left for the next meeting.";
        } else if (minutesLeft < 15) {
            return "Less than fifteen minutes left for the next meeting.";
        } else if (minutesLeft < 30) {
            return "Less than thirty minutes left for the next meeting.";
        } else if (minutesLeft < 60) {
            return "Less than one hour left for the next meeting.";
        }
        return "";
    }
}
