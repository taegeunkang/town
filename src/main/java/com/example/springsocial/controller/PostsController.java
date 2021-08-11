package com.example.springsocial.controller;

import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.CommentDTO;
import com.example.springsocial.dto.CommentWithPostDTO;
import com.example.springsocial.dto.PostDTO;
import com.example.springsocial.dto.PostTmpDTO;
import com.example.springsocial.service.CommetsService;
import com.example.springsocial.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@RestController
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
    // 1개만 반환이므로 반환형 List<Object[]> 이거 바꿔야함
    @GetMapping("/post/board")
    public List<Object [] > getOnePost(@RequestParam(value = "id") Long id) {
        return postsService.getPostWithUserInfo(id);
    }

    @GetMapping(value = "/image/{imagename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte []> getImage(@PathVariable("imagename") String imagename) throws IOException {
        System.out.println("Image NAme is "+ imagename);
        InputStream inputStream = new FileInputStream("/Users/deankang/postImg/user1/128/"+imagename);
        byte[] imageToByteArray = IOUtils.toByteArray(inputStream);

        System.out.println(imageToByteArray);
        inputStream.close();
        return new ResponseEntity<>(imageToByteArray, HttpStatus.OK);

    }

    @PostMapping("/post/upload")
    public List<Object[]> setPost(@RequestBody PostDTO postDTO) {
        System.out.println(postDTO.getUser());
        System.out.println(postDTO.getContent());
        postsService.save(postDTO);
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }
    @PostMapping("/post/upload/testfiles")
    public void setPost1(@ModelAttribute PostTmpDTO postTmpDTO) throws IOException {
        System.out.println("------------Test-----");
        postsService.saveTest(postTmpDTO);

    }
    @PostMapping("/post/delete")
    public List<Object[]> deletePost(@RequestBody Post post){
        System.out.println(post.getId());
        postsService.deleteById(post.getId());
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }

    @PostMapping("/post/edit")
    public int editPost(@RequestBody Post post) {
        return postsService.updatePost(post);
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
    @PostMapping("/comment/delete")
    public List<Object[]> deleteComment(@RequestBody CommentWithPostDTO commentWithPostDTO){
        return commetsService.deleteById(commentWithPostDTO.getCommentId(), commentWithPostDTO.getPostId());
    }


}
