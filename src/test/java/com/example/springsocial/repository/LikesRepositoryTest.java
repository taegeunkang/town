package com.example.springsocial.repository;

import com.example.springsocial.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LikesRepositoryTest {

    @Autowired
    private LikesRepository likesRepository;

    @Test
    public void 테스트트트() {
       likesRepository.findPostsByUserId(1L).forEach(objects -> System.out.println(Arrays.toString(objects)));
    }

}