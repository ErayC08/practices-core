package com.example.meeting;

import com.example.meeting.exception.InvalidLocalDateTimeException;
import com.example.meeting.exception.InvalidTitleException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeetingUnitTest {
    @Test
    void givenArgsExcludingTitle_whenConstructMeeting_thenThrowInvalidTitleException() {
        LocalDateTime localDateTime = LocalDateTime.of(2100, Month.JANUARY, 2, 23, 59);

        assertThrows(InvalidTitleException.class, () -> new Meeting(null, null, localDateTime));
    }

    @Test
    void givenArgsIncludingEmptyTitle_whenConstructMeeting_thenThrowInvalidTitleException() {
        LocalDateTime localDateTime = LocalDateTime.of(2100, Month.JANUARY, 2, 23, 59);

        assertThrows(InvalidTitleException.class, () -> new Meeting("", null, localDateTime));
    }

    @Test
    void givenArgsExcludingLocalDateTime_whenConstructMeeting_thenThrowInvalidDateException() {
        assertThrows(InvalidLocalDateTimeException.class, () -> new Meeting("Sample Title", null, null));
    }

    @Test
    void givenArgsIncludingPastLocalDateTime_whenConstructMeeting_thenThrowInvalidDateException() {
        final LocalDateTime pastLocalDateTime = LocalDateTime.of(2000, Month.JANUARY, 2, 23, 59);

        assertThrows(InvalidLocalDateTimeException.class, () -> new Meeting("Sample Title", null, pastLocalDateTime));
    }
}
