package com.example.springsocial.dto;

import com.example.springsocial.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostDTOTest {

    @Test
    public void 테스트트트트() {

       PostDTO postDTO = new PostDTO("hi", 2L);
       Post post = postDTO.toEntity();
        System.out.println(post.getId());


    }

}