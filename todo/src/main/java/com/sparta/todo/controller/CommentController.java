package com.sparta.todo.controller;

import com.sparta.todo.dto.CommentRequestDto;
import com.sparta.todo.dto.CommentResponseDto;
import com.sparta.todo.repository.Comment;
import com.sparta.todo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/{todoId}")
@RestController
@AllArgsConstructor
public class CommentController {

    public final CommentService commentService;

    // 댓글 생성
    @PostMapping("/comments")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto dto) {

        Comment comment = commentService.createComment(dto);
        return ResponseEntity.ok(new CommentResponseDto(comment));
    }

    // 댓글 조회
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long commentId) {
        Optional<Comment> comment = commentService.getComment(commentId);
        if (comment.isPresent()) {
            CommentResponseDto response = new CommentResponseDto(comment.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 댓글 수정
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto dto) {

        Comment updateComment = commentService.updateComment(commentId, dto);
        return ResponseEntity.ok(new CommentResponseDto(updateComment));
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId, @RequestParam CommentRequestDto dto) {
        commentService.deleteComment(commentId, dto);
        return ResponseEntity.noContent().build();
    }
}

