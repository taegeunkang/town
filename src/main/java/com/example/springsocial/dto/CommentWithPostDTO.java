package com.example.springsocial.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentWithPostDTO {
    private final Long postId;
    private final Long commentId;

}
