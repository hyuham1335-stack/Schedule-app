package com.scheduleapp.dto.scheduledto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String contents;
    private String writerName;
    private String password;
}
