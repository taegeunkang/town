package com.example.springsocial.dto;


import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentDTO {
    private final String content;
    private final Post post;

    public Comment toEntity() {
        return Comment.builder().content(content).post(post).build();
    }

}
