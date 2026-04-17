package com.app.restful.api;


import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.PostResponseDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.dto.PostWriteRequestDTO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;


    @Operation(summary = "게시글 목록 조회 서비스", description = "게시글 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @GetMapping
    public ResponseEntity<ApiResponseDTO> getPostList(){
        List<PostResponseDTO> postList = postService.getPostList();
//        .status: 상태코드 -> mdn 상태코드
//        .body: 응답 데이터 -> ApiResponseDTO
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 목록 조회 성공", postList));

    }

    @Operation(summary = "게시글 상세 조회 서비스", description = "게시글을 조회해서 상세정보를 보여주는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getPostInfo(@PathVariable Long id){
        PostResponseDTO postInfo = postService.getPostInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 상세 조회 성공", postInfo));
    }

    @Operation(summary = "게시글 작성 서비스", description = "게시글을 작성하는 서비스")
    @ApiResponse(responseCode = "201", description = "게시글 작성 성공")
    @ApiResponse(responseCode = "400", description = "잘못된 요청")
    @PostMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> writePost(@RequestBody PostWriteRequestDTO postWriteRequestDTO, @PathVariable Long id){

        postWriteRequestDTO.setMemberId(id);
        postService.writePost(postWriteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("게시글 작성 성공", null));
    }

    @Operation(summary = "게시글 수정 서비스", description = "게시글을 수정하는 서비스")
    @ApiResponse(responseCode = "200", description = "게시글 수정 성공")
    @ApiResponse(responseCode = "404", description = "게시글 수정 실패")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseDTO> updatePost(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO, @PathVariable Long id){

        postUpdateRequestDTO.setId(id);
        postService.updatePost(postUpdateRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 수정 성공"));
    }


    @Operation(summary = "게시글 삭제 서비스", description = "게시글 ID로 게시글 삭제해주는 서비스")
    @ApiResponse(responseCode = "204", description = "삭제 성공")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> deletePost(@PathVariable Long id){

        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("삭제 성공"));
    }

    @Operation(summary = "회원탈퇴시 게시글 삭제 서비스", description = "회원탈퇴 시 작성한 게시글 삭제해주는 서비스")
    @ApiResponse(responseCode = "204", description = "삭제 성공")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "memberId",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<ApiResponseDTO> deletePostByMemberId(@PathVariable Long memberId){

        postService.deletePostByMemberId(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("삭제 성공"));
    }

}
