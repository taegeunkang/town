package com.example.springsocial.service;

import com.example.springsocial.dto.DisLikesDTO;
import com.example.springsocial.repository.DisLikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DisLikesService {

    private final DisLikesRepository disLikesRepository;

    public Long save(DisLikesDTO disLikesDTO){
        return disLikesRepository.save(disLikesDTO.toEntity()).getId();
    }

    public List<Object> findPosts(Long id) {
        return disLikesRepository.findPostsByUserId(id);
    }
}
