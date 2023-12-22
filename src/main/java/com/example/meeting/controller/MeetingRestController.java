package com.example.meeting.controller;

import com.example.meeting.dto.MeetingDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meeting")
public class MeetingRestController {

    @PostMapping
    public boolean saveMeeting(@RequestBody MeetingDTO meetingDTO) {
        return false;
    }

}
