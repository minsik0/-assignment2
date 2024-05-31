package com.sparta.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    Optional<Comment> findByCommentId(Long commentId);


    Optional<Object> findByUserId(String userId);
}
