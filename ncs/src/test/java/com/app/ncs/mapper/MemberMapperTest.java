package com.app.ncs.mapper;

import com.app.ncs.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("테스터");
        memberVO.setMemberEmail("test0000@gmail.com");
        memberVO.setMemberPassword("test0000");
        memberMapper.insert(memberVO);
    }
    @Test
    public void selectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test0000@gmail.com");
        memberVO.setMemberPassword("test0000");
        Optional<MemberVO> findMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("findMember : {}", findMember);
    }
}
