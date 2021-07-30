package com.example.springsocial.service;

import com.example.springsocial.domain.Post;
import com.example.springsocial.repository.CommentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CommetsServiceTest {
    @Autowired
    private CommentsRepository commentsRepository;



}