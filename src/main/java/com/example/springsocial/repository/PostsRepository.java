package com.example.springsocial.repository;

import com.example.springsocial.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post,Long> {
//    //사용 안함
//    @Query("select p.id, p.content, p.createdDate, count(c) from Post p left outer join p.comments c where p.id > 0 group by p order by p.createdDate desc")
//    List<Object[]> getPostsWithCommentsCount();
    //메인 페이지 전체 게시글 조회
    @Query("select p.id, p.content, p.createdDate , p.comments.size ,p.user.id, p.user.name, p.user.imageUrl, p.images.size from Post p group by p order by p.createdDate desc ")
    List<Object[]> getPostsWithCommentsCountWithUserInfo();


    //board 호출
    @Query("select p.id, p.content, p.createdDate, u.id ,u.name, u.imageUrl, count(i)  from Post p inner join User u on u = p.user left outer join Image i on i.post = p  where p.id = ?1 group by p ")
    List<Object[]> getPostWithUserInfo(Long id);

    //메인페이지 페이징 조회 + 댓글
    @Query("select p.id, p.content, p.createdDate , p.comments.size ,p.user.id, p.user.name, p.user.imageUrl, p.images.size, p.likes.size, p.disLikes.size from Post p group by p order by p.createdDate desc ")
    List<Object[]> getPostsWithCommentsCountWithUserInfoByPaging(Pageable page);


//
//    //메인페이지 페이징 조회 + 댓글
//    @Query("select p.id, p.content, p.createdDate , p.comments.size ,p.user.id, p.user.name, p.user.imageUrl, p.images.size, p.likes.size, p.disLikes.size from Post p where p.content like %:content% group by p  order by p.createdDate desc ")
//    List<Object[]> searchPosts(String content,Pageable page);



}



