package com.app.restful.service;

import com.app.restful.domain.dto.PostResponseDTO;
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
    private final PostResponseDTO postResponseDTO;

    @Override
    public List<PostResponseDTO> getPostList() {
        return postDAO.findAll().stream().map(PostResponseDTO::from).toList();
    }
}
