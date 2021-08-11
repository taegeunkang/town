package com.example.springsocial.dto;

import com.example.springsocial.domain.Post;
import com.example.springsocial.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor

public class PostTmpDTO {
    private final Long user;
    private final String content;
    private final List<MultipartFile> files;

    public Post toEntity() {
        User usr = new User();
        usr.setId(user);
        return Post.builder().user(usr).content(content).build();
    }

}
