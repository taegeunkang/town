package com.example.springsocial.service;

import com.example.springsocial.domain.Image;
import com.example.springsocial.domain.Post;
import com.example.springsocial.dto.PostDTO;
import com.example.springsocial.dto.PostTmpDTO;
import com.example.springsocial.repository.ImageRepository;
import com.example.springsocial.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final ImageRepository imageRepository;

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

    public void saveTest(PostTmpDTO postTmpDTO) throws IOException {
        Post post =postsRepository.save(postTmpDTO.toEntity());
        if(!postTmpDTO.getFiles().isEmpty()) {
            Long pId = post.getId();
            String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
            int cnt =0 ;
            for(MultipartFile file: postTmpDTO.getFiles()){
                String filePath = rootPath+"/postImg/user"+postTmpDTO.getUser()+"/"+pId+"/img"+cnt;
                File dest = new File(filePath);
                boolean res = false;
                if(!dest.exists()) {
                     res = dest.mkdirs();
                }
                file.transferTo(dest);
                Image image = Image.builder().name("img"+cnt).path(filePath).filesize(file.getSize()).post(post).build();
                imageRepository.save(image);
                cnt++;
                System.out.println(filePath);

            }


        }


    }
}
