package com.example.springsocial.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CommentsRepositoryTest {

    @Autowired
    private CommentsRepository commentsRepository;

    @Test
    public void 조회테스트() {
        List<Object []> lists = commentsRepository.findByPostIdWithUser(12L);
        lists.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });
    }

}