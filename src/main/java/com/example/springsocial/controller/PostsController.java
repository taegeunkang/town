package com.example.springsocial.controller;

import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.CommentDTO;
import com.example.springsocial.dto.PostDTO;
import com.example.springsocial.service.CommetsService;
import com.example.springsocial.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController()
public class PostsController {

    private final PostsService postsService;
    private final CommetsService commetsService;

    @PostMapping("/post")
    public List<Object[]> getPosts() {
//
//        List<Object[]> tmp = postsService.getPostsWithCommentsCount();
//        tmp.forEach(objects -> System.out.println(Arrays.toString(objects)));
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }
    @GetMapping("/post/commentscount")
    public void getCommentsCount() {

    }

    @PostMapping("/post/upload")
    public List<Object[]> setPost(@RequestBody PostDTO postDTO) {
        System.out.println(postDTO.getUser());
        System.out.println(postDTO.getContent());
        postsService.save(postDTO);
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }
    @PostMapping("/post/delete")
    public List<Object[]> deletePost(@RequestBody Long id){
        System.out.println(id);
        postsService.deleteById(id);
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }
    @GetMapping("/comment/load")
    public List<Comment> getComments(@RequestParam Post post) {
        System.out.println(post.getId());
        return commetsService.getcomments(post.getId());
    }

    @PostMapping("/comment/insert")
    public List<Comment> setComments(CommentDTO commentDTO){
        System.out.println(commentDTO.getContent());
        commetsService.save(commentDTO);
        return commetsService.getcomments(commentDTO.getPost().getId());

    }
}
