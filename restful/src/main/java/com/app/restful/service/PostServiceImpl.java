package com.app.restful.service;

import com.app.restful.domain.dto.*;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.exception.MemberException;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostResponseDTO> getPostList() {
        return postDAO.findAll().stream().map(PostResponseDTO::from).toList();
    }

    @Override
    public PostResponseDTO getPostInfo(Long id) {
        postDAO.updateReadCount(id);
        return postDAO.findById(id)
                .map(PostResponseDTO::from)
                .orElseThrow(()->{throw new PostException("게시글을 찾을 수 없습니다.");});
    }

    @Override
    public void writePost(PostWriteRequestDTO postWriteRequestDTO){
        postDAO.save(PostDTO.from(postWriteRequestDTO));
    }

    @Override
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO){
        postDAO.update(PostDTO.from(postUpdateRequestDTO));
    }

    @Override
    public void deletePost(Long id){
        postDAO.delete(id);
    }

    @Override
    public void deletePostByMemberId(Long memberId){
        postDAO.deleteByMemberId(memberId);
    }
}
