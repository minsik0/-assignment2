package com.sparta.todo.dto;

import com.sparta.todo.repository.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto {
    private Long commentId;

    private String comment;

    private String userId;

    private String scheduleId;

    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment){
        this.commentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.userId = comment.getUserId();
        this.scheduleId = comment.getScheduleId();
        this.createdAt = comment.getCreatedAt();
    }
}
