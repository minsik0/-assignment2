package com.sparta.todo.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id", nullable = false)

    private Long commentId;

    private String comment;

    private String userId;

    private String ScheduleId;

    private LocalDateTime createdAt;


    @Builder
    public Comment(String comment, String userId, String ScheduleId) {
        this.comment = comment;
        this.userId = userId;
        this.ScheduleId = ScheduleId;
        this.createdAt = LocalDateTime.now();
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }
}
