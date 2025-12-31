package com.scheduleapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String writerName;

    public UpdateScheduleResponse(Long id, String title, String contents, String writerName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
    }
}
