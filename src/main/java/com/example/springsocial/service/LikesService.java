package com.example.springsocial.service;


import com.example.springsocial.dto.LikesDTO;
import com.example.springsocial.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public Long save(LikesDTO likesDTO) {
        return likesRepository.save(likesDTO.toEntity()).getId();
    }

    public List<Object> findPosts(Long id) { return likesRepository.findPostsByUserId(id);}
}
