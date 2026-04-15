package com.app.restful.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class PostDTO implements Serializable {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;
    private String memberEmail;
    private String memberName;

    public static PostDTO from(PostResponseDTO postResponseDTO) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postResponseDTO.getId());
        postDTO.setPostTitle(postResponseDTO.getPostTitle());
        postDTO.setPostContent(postResponseDTO.getPostContent());
        postDTO.setPostReadCount(postResponseDTO.getPostReadCount());
        postDTO.setMemberEmail(postResponseDTO.getMemberEmail());
        postDTO.setMemberName(postResponseDTO.getMemberName());
        return postDTO;
    }

    public static PostDTO from(PostWriteRequestDTO postWriteRequestDTO) {
        PostDTO postDTO = new PostDTO();
        postDTO.setMemberId(postWriteRequestDTO.getMemberId());  // 추가
        postDTO.setPostTitle(postWriteRequestDTO.getPostTitle());
        postDTO.setPostContent(postWriteRequestDTO.getPostContent());
        postDTO.setPostReadCount(0L);  // 초기값 0 고정
        return postDTO;
    }

    public static PostDTO from(PostUpdateRequestDTO postUpdateRequestDTO) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postUpdateRequestDTO.getId());
        postDTO.setPostTitle(postUpdateRequestDTO.getPostTitle());
        postDTO.setPostContent(postUpdateRequestDTO.getPostContent());
        return postDTO;
    }
}
