package com.example.springsocial.repository;

import com.example.springsocial.domain.User;
import com.example.springsocial.dto.LikesDTO;
import com.example.springsocial.dto.PostDTO;
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

//    @Test
//    public void 삭제테스트() {
//        LikesDTO likesDTO;
//        likesDTO = new LikesDTO(1L, 1L);
//        System.out.println(likesDTO.getPost());
//        System.out.println(likesDTO.getUser());
//
//        likesRepository.deleteByPostIdandUserId(likesDTO.getPost(), likesDTO.getUser());
//    }

}