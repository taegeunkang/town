package com.example.springsocial.controller;

import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.CommentDTO;
import com.example.springsocial.dto.PostDTO;
import com.example.springsocial.service.CommetsService;
import com.example.springsocial.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<Object[]> deletePost(@RequestBody Post post){
        System.out.println(post.getId());
        postsService.deleteById(post.getId());
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }
    @GetMapping("/comment/load")
    public List<Object []> getComments(@RequestParam(value = "id") Long id) {
        return commetsService.getComemntsWithUser(id);
    }

    @PostMapping("/comment/insert")
    public List<Object []> setComments(@RequestBody CommentDTO commentDTO){
        System.out.println("rrrrrrrrrrrrrrrrrrrr");
        System.out.println(commentDTO.getContent());
        commetsService.save(commentDTO);
        return commetsService.getComemntsWithUser(commentDTO.getPost());

    }


}
