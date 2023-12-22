package com.example.meeting;

import com.example.meeting.dto.MeetingDTO;
import com.example.meeting.exception.InvalidLocalDateTimeException;
import com.example.meeting.exception.InvalidTitleException;
import com.example.meeting.mapper.MeetingMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeetingTest {

    @Test
    void givenArgsIncludingEmptyTitle_whenConstructNewMeetingInstance_thenThrowInvalidTitleException() {
        final String emptyTitle = "";
        final String localDateTimeInString = "2999-01-01 13:59";

        MeetingDTO meetingDTO = new MeetingDTO();

        meetingDTO.setTitle(emptyTitle);
        meetingDTO.setLocalDateTime(localDateTimeInString);

        Assertions.assertThrows(InvalidTitleException.class, () -> MeetingMapper.getInstance().toMeeting(meetingDTO));
    }

    @Test
    void givenArgsIncludingPastLocalDateTime_whenConstructNewMeetingInstance_thenThrowInvalidLocalDateTimeException() {
        final String title = "Sample Title";
        final String pastLocalDateTimeInString = "1999-01-01 13:59";

        MeetingDTO meetingDTO = new MeetingDTO();

        meetingDTO.setTitle(title);
        meetingDTO.setLocalDateTime(pastLocalDateTimeInString);

        Assertions.assertThrows(InvalidLocalDateTimeException.class, () -> MeetingMapper.getInstance().toMeeting(meetingDTO));
    }
}
