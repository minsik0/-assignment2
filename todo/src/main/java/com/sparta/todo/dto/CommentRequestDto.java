package com.sparta.todo.dto;

import com.sparta.todo.repository.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private String comment;

    private String userId;

    private String scheduleId;

    public Comment toEntity() {
        return Comment.builder()
                .comment(comment)
                .userId(userId)
                .ScheduleId(scheduleId)
                .build();
    }

}
