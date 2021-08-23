package com.example.springsocial.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 조회_테스트() {
        postsRepository.getPostsWithCommentsCountWithUserInfoByPaging(PageRequest.of(1,20)).forEach(object -> {
            System.out.println(Arrays.toString(object));
        });
    }

    @Test
    public void 좋아요_테스트() {
        postsRepository.searchPosts("http", PageRequest.of(1, 20)).forEach(objects -> {
            System.out.println(objects);
        });
    }




}