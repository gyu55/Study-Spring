package com.app.controller.mapper;


import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void memberInsertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test8888@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("김영희");
        memberMapper.insert(memberVO);
    }
}
