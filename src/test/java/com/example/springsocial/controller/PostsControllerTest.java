package com.example.springsocial.controller;

import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import com.example.springsocial.domain.User;
import com.example.springsocial.dto.CommentDTO;
import com.example.springsocial.repository.CommentsRepository;
import com.example.springsocial.repository.PostsRepository;
import com.example.springsocial.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsControllerTest {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private UserRepository userRepository;

    @WithMockUser(value = "USER")
    @Test
    public void 테스트() {
//        Optional<Post> post = postsRepository.findById(12L);
//        Optional<User> user = userRepository.findById(1L);
//
//        CommentDTO commentDTO = new CommentDTO("Hello", post.get().getId(), user.get().getId());
//        Comment comment = commentsRepository.save(commentDTO.toEntity());
//



    }

}