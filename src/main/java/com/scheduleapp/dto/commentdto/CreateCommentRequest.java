package com.scheduleapp.dto.commentdto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {

    private String contents;
    private String writerName;
    private String password;
}
