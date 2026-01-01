package com.scheduleapp.dto.commentdto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {
    private final Long id;
    private final String contents;
    private final String writerName;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public GetCommentResponse(Long id, String contents, String writerName, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.contents = contents;
        this.writerName = writerName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
