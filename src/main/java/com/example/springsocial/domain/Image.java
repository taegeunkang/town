package com.example.springsocial.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String path;
    @Column(nullable = true)
    private Long filesize;

    @ManyToOne
    private Post post;

    @Builder
    private Image(String name, String path, Long filesize, Post post){
        this.name = name;
        this.path =path;
        this.filesize = filesize;
        this.post = post;
    }



}
