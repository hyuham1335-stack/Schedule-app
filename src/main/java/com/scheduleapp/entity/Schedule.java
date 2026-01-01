package com.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String writerName;
    private String password;

    @OneToMany(mappedBy = "schedule")
    private final List<Comment> comments = new ArrayList<>();

    public Schedule(String title, String contents, String writerName, String password) {
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
        this.password = password;
    }

    public void updateSchedule(String title, String writerName){
        this.title = title;
        this.writerName = writerName;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
