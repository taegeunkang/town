package com.example.springsocial.repository;


import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long id);

    @Query(value = " select c.id, c.created_date, c.content, c.post_id , c.user_id, u.name, u.image_url from comment c inner join user u on c.user_id = u.id where post_id = :userid order by c.created_date asc", nativeQuery = true)
    List<Object []> findByPostIdWithUser(@Param("userid") Long userid);

}
