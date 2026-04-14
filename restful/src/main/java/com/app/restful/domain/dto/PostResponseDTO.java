package com.app.restful.domain.dto;

import com.app.restful.domain.vo.PostVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "게시글 정보")
public class PostResponseDTO {
    @Schema(description = "게시글 번호", required = true, example = "1")
    private Long id;

    @Schema(description = "게시글 제목", required = true, example = "테스트 게시글 제목123!@#")
    private String postTitle;

    @Schema(description = "게시글 내용", required = true, example = "테스트 게시글 내용123!@#")
    private String postContent;

    @Schema(description = "회원 번호", required = true, example = "1")
    private Long memberId;

    @Schema(description = "게시글 조회수", required = true, example = "1")
    private Long postReadCount;

    @Schema(description = "회원 이메일", required = true, example = "test123@gmail.com")
    private String memberEmail;

    @Schema(description = "회원 이름", example = "홍길동")
    private String memberName;

    public static PostResponseDTO from(PostDTO postDTO) {
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setId(postDTO.getId());
        postResponseDTO.setPostTitle(postDTO.getPostTitle());
        postResponseDTO.setPostContent(postDTO.getPostContent());
        postResponseDTO.setMemberId(postDTO.getMemberId());
        postResponseDTO.setPostReadCount(postDTO.getPostReadCount());
        postResponseDTO.setMemberEmail(postDTO.getMemberEmail());
        postResponseDTO.setMemberName(postDTO.getMemberName());
        return postResponseDTO;
    }
}
