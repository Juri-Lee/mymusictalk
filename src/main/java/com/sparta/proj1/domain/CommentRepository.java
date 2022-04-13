package com.sparta.proj1.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();

//    @Query(value = "SELECT p FROM Comment p WHERE p.contentId = :boardId")
    List<Comment> findAllByContentIdOrderByModifiedAtDesc( Long contentId);
}
