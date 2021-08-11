package com.example.springsocial.service;

import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.PostDTO;
import com.example.springsocial.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Post save(PostDTO postDTO) {
        return postsRepository.save(postDTO.toEntity());
    }

    public List<Post> findAll() {
        return postsRepository.findAll();
    }

    public List<Object[]> getPostsWithCommentsCount() {
        return postsRepository.getPostsWithCommentsCount();
    }

    public List<Object[]> getPostsWithCommentsCountWithUserInfo() {
        return postsRepository.getPostsWithCommentsCountWithUserInfo();
    }
    // 1개만 반환이므로 반환형 List<Object[]> 이거 바꿔야함
    public List<Object[]> getPostWithUserInfo(Long id) {
        return postsRepository.getPostWithUserInfo(id);
    }

    public void deleteById(Long id) {
        postsRepository.deleteById(id);
    }

    public int updatePost(Post post) {
        Optional<Post> post1 = postsRepository.findById(post.getId());
        post1.get().setContent(post.getContent());
        postsRepository.save(post1.get());
        return 1;
    }
}
