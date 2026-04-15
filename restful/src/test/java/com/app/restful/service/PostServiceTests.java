package com.app.restful.service;


import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void getPostListTest(){
        log.info("postService : {}", postService.getPostList());
    }

    @Test
    public void getPostInfoTest(){
        log.info("postService : {}", postService.getPostInfo(5L));
    }

    @Test
    public void updatePostTest(){

        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setId(5L);
        postUpdateRequestDTO.setPostTitle("test");
        postUpdateRequestDTO.setPostContent("test");
        postService.updatePost(postUpdateRequestDTO);
    }
}
