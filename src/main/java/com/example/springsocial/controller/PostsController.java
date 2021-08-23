package com.example.springsocial.controller;

import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.*;
import com.example.springsocial.service.CommetsService;
import com.example.springsocial.service.DisLikesService;
import com.example.springsocial.service.LikesService;
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
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;
    private final CommetsService commetsService;
    private final LikesService likesService;
    private final DisLikesService disLikesService;

    @GetMapping("/post")
    public List<Object[]> getPosts(@RequestParam("number") int number) {

        return postsService.getPostsWithCommentsCountWithUserInfoByPaging(number);
    }
    // 1개만 반환이므로 반환형 List<Object[]> 이거 바꿔야함
    @GetMapping("/post/board")
    public List<Object [] > getOnePost(@RequestParam(value = "id") Long id) {
        return postsService.getPostWithUserInfo(id);
    }

    @GetMapping(value = "/image/{postnumber}/{imagename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte []> getImage(@PathVariable("postnumber") String number,@PathVariable("imagename") String imagename) throws IOException {
        InputStream inputStream = new FileInputStream("/Users/deankang/postImg/"+number+"/"+imagename);
        byte[] imageToByteArray = IOUtils.toByteArray(inputStream);

        inputStream.close();
        return new ResponseEntity<>(imageToByteArray, HttpStatus.OK);

    }

    @PostMapping("/post/upload")
    public List<Object[]> setPost(@RequestBody PostDTO postDTO) {
        postsService.save(postDTO);
        return postsService.getPostsWithCommentsCountWithUserInfo();

    }

    //게시글 등록 (이미지 첨부 기능 추가)
    @PostMapping("/post/upload/testfiles")
    public List<Object[]> setPost1(@ModelAttribute PostTmpDTO postTmpDTO) throws IOException {
        postsService.saveTest(postTmpDTO);
        return postsService.getPostsWithCommentsCountWithUserInfo();
    }

    // 게시글 삭제
    @PostMapping("/post/delete")
    public List<Object[]> deletePost(@RequestBody Post post){
        postsService.deleteImage(post.getId());
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
        commetsService.save(commentDTO);
        return commetsService.getComemntsWithUser(commentDTO.getPost());

    }
    @PostMapping("/comment/delete")
    public List<Object[]> deleteComment(@RequestBody CommentWithPostDTO commentWithPostDTO){
        return commetsService.deleteById(commentWithPostDTO.getCommentId(), commentWithPostDTO.getPostId());
    }

    //좋아요 저장
    @PostMapping("/post/like")
    public Long setLike(@RequestBody LikesDTO likesDTO) {
        return likesService.save(likesDTO);
    }

    //싫어요 저장
    @PostMapping("/post/dislike")
    public Long setDisLike(@RequestBody DisLikesDTO disLikesDTO){
        return disLikesService.save(disLikesDTO);
    }

    //유저가 좋아요 한 게시글 번호 조회
    @GetMapping("/post/likes/user")
    public List<Object> getLikes(@RequestParam(value = "id") Long id) {
        return likesService.findPosts(id);
    }

    //유저가 싫어요 한 게시글 번호 조회
    @GetMapping("/post/dislikes/user")
    public List<Object> getDisLikes(@RequestParam(value = "id") Long id) {
        return disLikesService.findPosts(id);
    }
}
