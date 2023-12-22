package com.example.meeting.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class MeetingDTOTest {

    @Test
    void whenReadMeetingDTO_thenSuccessful() throws JsonProcessingException {
        MeetingDTO meetingDTO = new ObjectMapper().readValue("{\"title\":\"Sample Title\",\"localDateTime\":\"2999-01-01 13:59\"}", MeetingDTO.class);

        Assertions.assertEquals("Sample Title", meetingDTO.getTitle());
        Assertions.assertNull(meetingDTO.getDescription());
        Assertions.assertEquals("2999-01-01 13:59",
                meetingDTO.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
