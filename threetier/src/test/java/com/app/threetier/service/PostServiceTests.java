package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
//    부모인 인터페이스에 자식인 구현체가 들어와, Upcasting
    private PostService postService;

    @Test
    void getPostTest() {

        log.info("posts: {}", postService.getPost(1000L));
    }

    @Test
    void updatePostTest() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(2L);
        postDTO.setPostTitle("testTitle");
        postDTO.setPostContent("testContent");
        postService.updatePost(postDTO);
    }

    @Test
    void deletePostTest() {
        postService.deletePost(3L);

    }
}
