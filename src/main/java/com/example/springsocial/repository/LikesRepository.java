package com.example.springsocial.repository;

import com.example.springsocial.domain.Likes;
import com.example.springsocial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    //유저가 어떤 게시글을 좋아요 눌렀는지 조회
    @Query(value = "select post_id from likes where user_id = ?1", nativeQuery = true)
    List<Object> findPostsByUserId(Long id);
}
