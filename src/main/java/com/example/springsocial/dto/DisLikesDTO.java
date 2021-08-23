package com.example.springsocial.dto;


import com.example.springsocial.domain.DisLikes;
import com.example.springsocial.domain.Post;
import com.example.springsocial.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DisLikesDTO {
    private final Long post;
    private final Long user;

    public DisLikes toEntity() {
        Post post1 = new Post();
        post1.setId(post);
        User user1 = new User();
        user1.setId(user);
        return DisLikes.builder().post(post1).user(user1).build();
    }
}
