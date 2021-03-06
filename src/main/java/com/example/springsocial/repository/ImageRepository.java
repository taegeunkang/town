package com.example.springsocial.repository;

import com.example.springsocial.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Long countByPostId(Long id);
}
