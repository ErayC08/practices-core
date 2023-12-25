package com.example.meeting.service;

import com.example.meeting.Meeting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeetingService {

    List<Meeting> findAll();
}
