package com.scheduleapp.dto.scheduledto;

import com.scheduleapp.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FindAllScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String writerName;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;


    public FindAllScheduleResponse(Long id, String title, String content, String writerName, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
