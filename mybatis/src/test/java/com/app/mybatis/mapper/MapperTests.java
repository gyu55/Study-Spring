package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PostMapper postMapper;


    @Test
    public void mapperTests() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void mapperTests2() {
        log.info(timeMapper.getTime2());
    }

    @Test
    public void mapperTests3() {
        log.info(memberMapper.selectAll().toString());
    }

    @Test
    public void mapperTests4() {
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void mapperTests5(){
//        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberEmail("test789@gmail.com");
//        memberVO.setMemberPassword("test123!@#");
//        memberVO.setMemberName("장보고");

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("이순신");
        memberMapper.insert(memberVO);
    }

    @Test
    public void updateTests(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(2L);
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("장길동");

        memberMapper.select(2L).map(MemberVO::toString).ifPresent(log::info);
        memberMapper.update(memberVO);
        memberMapper.select(2L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTests(){
        memberMapper.delete(2L);
    }



}
