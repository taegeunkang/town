package com.example.springsocial.repository;

import com.example.springsocial.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post,Long> {

    @Query("select p.id, p.content, p.createdDate, count(c) from Post p left outer join p.comments c where p.id > 0 group by p order by p.createdDate desc")
    List<Object[]> getPostsWithCommentsCount();
//    @Query("select p.id, p.content, p.createdDate, count(c), u.imageUrl, u.name from Post p left outer join p.comments c join User u where p.id > 0 group by p ")
    @Query(value = "select a.id, a.content,a.created_date, a.cnt, a.user_id, u.name, u.image_url , count(i.id) from (select p.id, p.content,p.created_date,p.user_id, count(c.id) as cnt from post p left join comment c on c.post_id = p.id group by p.id) as a inner join user u on u.id = a.user_id left join image i on i.post_id = a.id group by a.id order by created_date desc;", nativeQuery = true)
    List<Object[]> getPostsWithCommentsCountWithUserInfo();


    @Query("select p.id, p.content, p.createdDate, u.id ,u.name, u.imageUrl from Post p inner join User u on u = p.user where p.id = ?1")
    List<Object[]> getPostWithUserInfo(Long id);

}



