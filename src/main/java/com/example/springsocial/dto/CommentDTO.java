package com.example.springsocial.dto;


import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import com.example.springsocial.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentDTO {
    private final String content;
    private final Long post;
    private final Long user;


    public Comment toEntity() {
        Post post1 = new Post();
        post1.setId(post);
        User user1 = new User();
        user1.setId(user);


        return Comment.builder().content(content).post(post1).user(user1).build();
    }

}
