package com.scheduleapp.dto.scheduledto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {

    private String title;
    private String writerName;
    private String password;
}
