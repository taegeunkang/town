package com.example.springsocial.dto;

import com.example.springsocial.domain.Post;
import com.example.springsocial.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PostDTO {
    private final String content;
    private final Long user;

    public Post toEntity(){
        User usr = new User();
        usr.setId(user);
        return Post.builder().content(content).user(usr).build();
    }
}
