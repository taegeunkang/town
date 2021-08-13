package com.example.springsocial.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ImageRepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void 갯수조회() {
        Long count = imageRepository.countByPostId(165L);
        System.out.println(count);
    }
}