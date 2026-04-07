package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);
}
