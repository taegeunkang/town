package com.example.springsocial.repository;

import com.example.springsocial.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post,Long> {

    @Query("select p.id, p.content, p.createdDate, count(c) from Post p left outer join p.comments c where p.id > 0 group by p order by p.createdDate desc")
    List<Object[]> getPostsWithCommentsCount();
    @Query("select p.id, p.content, p.createdDate, count(c), u.imageUrl, u.name from Post p left outer join p.comments c join User u where p.id > 0 group by p ")
    List<Object[]> getPostsWithCommentsCountWithUserInfo();

}

