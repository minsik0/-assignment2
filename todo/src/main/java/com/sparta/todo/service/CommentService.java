package com.sparta.todo.service;

import com.sparta.todo.dto.CommentRequestDto;
import com.sparta.todo.repository.Comment;
import com.sparta.todo.repository.CommentRepository;
import com.sparta.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;

    // 댓글 생성
    public Comment createComment(CommentRequestDto dto) {
        //선택한 일정의 아이디를 입력받지 않은 경우
//        if( == null){
//            throw new IllegalArgumentException("선택한 일정의 아이디를 입력받지 않았습니다.");
//        }

        // 댓글 내용이 비어 있는 경우
        if (dto.getComment() == null || dto.getComment().isEmpty()) {
            throw new IllegalArgumentException("댓글 내용이 비어 있습니다.");
        }

        //DB에 저장되지 않은 경우
        var Comment = commentRepository.findByUserId(dto.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        var newComment = dto.toEntity();
        return commentRepository.save(newComment);
    }

    // 댓글 조회
    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.findByCommentId(commentId);
    }

    // 댓글 수정
    public Comment updateComment(Long commentId, CommentRequestDto dto) {


        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        if(comment.getComment() == null )


        comment.setComment(dto.getComment());
        comment.setUserId(dto.getUserId());
        return commentRepository.save(comment);
    }

        // 댓글 삭제
        public void deleteComment(Long commentId, CommentRequestDto dto) {

            // 댓글이 DB에 저장되지 않은 경우
            Comment comment = commentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

            // 댓글이 속한 일정의 ID 체크
            if (!comment.getComment().equals(dto.getUserId())) {
                throw new IllegalArgumentException("잘못된 일정 ID 입니다.");
            }



            commentRepository.delete(comment);
        }


}
