package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<PostDTO> selectAll();
    public PostDTO selectById(Long id);
    public void insert(PostDTO postDTO);
    public void update(PostDTO postDTO);
    public void updateReadCount(Long id);
    public void delete(Long id);
    public void deleteByMemberId(Long memberId);
}


