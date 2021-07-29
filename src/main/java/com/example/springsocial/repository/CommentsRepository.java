package com.example.springsocial.repository;


import com.example.springsocial.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long id);


}
