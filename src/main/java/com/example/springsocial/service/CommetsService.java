package com.example.springsocial.service;

import com.example.springsocial.domain.Comment;
import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.CommentDTO;
import com.example.springsocial.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommetsService {
    private final CommentsRepository commentsRepository;

    public Comment save(CommentDTO commentDTO) {
        return commentsRepository.save(commentDTO.toEntity());
    }

    public List<Comment> getcomments(Long id) {
        return commentsRepository.findByPostId(id);
    }

    public List<Object []> getComemntsWithUser(Long id) {
        return commentsRepository.findByPostIdWithUser(id);

    }

}
