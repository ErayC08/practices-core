package com.example.meeting.mapper;

import com.example.meeting.Meeting;
import com.example.meeting.dto.MeetingDTO;

public class MeetingMapper {

    public Meeting toMeeting(MeetingDTO meetingDTO) {
        Meeting meeting = new Meeting();

        meeting.setTitle(meetingDTO.getTitle());
        meeting.setDescription(meetingDTO.getDescription());
        meeting.setLocalDateTime(meetingDTO.getLocalDateTime());

        return meeting;
    }

    public static MeetingMapper getInstance() {
        return new MeetingMapper();
    }
}
