package com.scheduleapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String writerName;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public CreateScheduleResponse(Long id, String title, String contents, String writerName, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
