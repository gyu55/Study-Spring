package com.app.restful.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@Schema(description = "게시글 DTO")
public class PostDTO implements Serializable {
    @Schema(description = "게시글 번호", required = true, example = "1")
    private Long id;
    @Schema(description = "게시글 제목", required = true, example = "게시글 제목1")
    private String postTitle;
    @Schema(description = "게시글 내용", required = true, example = "게시글 내용1")
    private String postContent;
    @Schema(description = "회원 번호", required = true, example = "1")
    private Long memberId;
    @Schema(description = "게시글 조회수", required = true, example = "1")
    private Long postReadCount;
    @Schema(description = "회원 이메일", required = true, example = "test123@gmail.com")
    private String memberEmail;
    @Schema(description = "회원 이름", example = "홍길동")
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
