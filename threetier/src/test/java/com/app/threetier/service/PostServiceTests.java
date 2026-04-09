package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
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
        PostVO postVO = new PostVO();
        postDTO.setId(4L);
        postDTO.setPostTitle("testTitle");
        postDTO.setPostContent("testContent");
        postService.updatePost(postVO);
    }

    @Test
    void deletePostTest() {
        postService.deletePost(3L);

    }
}
