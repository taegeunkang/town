package com.example.springsocial.repository;

import com.example.springsocial.domain.DisLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisLikesRepository extends JpaRepository<DisLikes, Long> {

    //유저가 어떤 게시글을 싫어요 눌렀는지 조회
    @Query(value = "select post_id from dis_likes where user_id = ?1", nativeQuery = true)
    List<Object> findPostsByUserId(Long id);
}
