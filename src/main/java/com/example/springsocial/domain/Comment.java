package com.example.springsocial.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;


    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    @Builder
    private Comment(String content, Post post, User user){
        this.content = content;
        this.post = post;
        this.user = user;
    }

}
