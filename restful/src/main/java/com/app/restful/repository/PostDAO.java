package com.app.restful.repository;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

    public List<PostDTO> findAll(){
        return postMapper.selectAll();
    }

    public Optional<PostDTO> findById(Long id){
        return Optional.ofNullable(postMapper.selectById(id));
    }

    public void save(PostDTO postDTO){
        postMapper.insert(postDTO);
    }

    public void update(PostDTO postDTO){
        postMapper.update(postDTO);
    }

    public void updateReadCount(Long id) {
        postMapper.updateReadCount(id);
    }

    public void delete(Long id){
        postMapper.delete(id);
    }

    public void deleteByMemberId(Long memberId){
        postMapper.deleteByMemberId(memberId);
    }


}
