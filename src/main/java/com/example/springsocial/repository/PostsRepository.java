package com.example.springsocial.repository;

import com.example.springsocial.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post,Long> {
    //사용 안함
    @Query("select p.id, p.content, p.createdDate, count(c) from Post p left outer join p.comments c where p.id > 0 group by p order by p.createdDate desc")
    List<Object[]> getPostsWithCommentsCount();
    //메인 페이지 전체 게시글 조회
    @Query(value = "select a.id, a.content,a.created_date, a.cnt, a.user_id, u.name, u.image_url , count(i.id) from (select p.id, p.content,p.created_date,p.user_id, count(c.id) as cnt from post p left join comment c on c.post_id = p.id group by p.id) as a inner join user u on u.id = a.user_id left join image i on i.post_id = a.id group by a.id order by created_date desc;", nativeQuery = true)
    List<Object[]> getPostsWithCommentsCountWithUserInfo();

    //메인페이지 게시글 조회 (페이징)
    @Query(value = "select a.id, a.content,a.created_date, a.cnt, a.user_id, u.name, u.image_url , count(i.id) from (select p.id, p.content,p.created_date,p.user_id, count(c.id) as cnt from post p left join comment c on c.post_id = p.id group by p.id \n-- #pageable\n ) as a inner join user u on u.id = a.user_id left join image i on i.post_id = a.id group by a.id order by created_date desc;", countQuery = "select a.id, a.content,a.created_date, a.cnt, a.user_id, u.name, u.image_url , count(i.id) from (select p.id, p.content,p.created_date,p.user_id, count(c.id) as cnt from post p left join comment c on c.post_id = p.id group by p.id) as a inner join user u on u.id = a.user_id left join image i on i.post_id = a.id group by a.id;", nativeQuery = true)
    List<Object[]> getPostsWithCommentsCountWithUserInfoByPaging(Pageable page);

    //board 호출
    @Query("select p.id, p.content, p.createdDate, u.id ,u.name, u.imageUrl, count(i)  from Post p inner join User u on u = p.user left outer join Image i on i.post = p  where p.id = ?1 group by p ")
    List<Object[]> getPostWithUserInfo(Long id);

}



