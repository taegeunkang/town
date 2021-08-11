package com.example.springsocial.service;

import com.example.springsocial.domain.Post;
import com.example.springsocial.repository.PostsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsServiceTest {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;


    @WithMockUser(value = "USER")
    @Test
    public void 테스트() {
        Post post = new Post();
        post.setId(29L);
        post.setContent("수정 테스트");

        int res = postsService.updatePost(post);

        assertThat(res).isEqualTo(1);

    }

}