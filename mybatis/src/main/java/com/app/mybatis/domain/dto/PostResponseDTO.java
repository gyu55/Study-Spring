package com.app.mybatis.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PostResponseDTO {
//    DTO로 넣을 필요가 없음 화면 쪽에서 따로따로 받는 게 좋다
//    private PostCountDTO postCountDTO;

    private Long totalPageCount;
    private Long totalPostCount;
    private List<PostDTO> posts;
}
