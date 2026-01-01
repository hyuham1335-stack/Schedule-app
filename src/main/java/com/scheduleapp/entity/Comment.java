package com.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String contents;
    @Column(nullable = false)
    private String writerName;
    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_comment", nullable = false)
    private Schedule schedule;

    public Comment(String contents, String writerName, String password, Schedule schedule) {
        this.contents = contents;
        this.writerName = writerName;
        this.password = password;
        this.schedule = schedule;
    }

}
