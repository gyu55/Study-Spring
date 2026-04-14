package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void getMemberInfoTest() {
        log.info("memberService : {}", memberService.getMemberInfo(2L));
    }

    @Test
    public void insertMemberTest(){
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberName("test");
        memberJoinRequestDTO.setMemberEmail("testgyu@gmail.com");
        memberJoinRequestDTO.setMemberPassword("gyu123!@#");
        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void memberUpdateTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setId(2L);
        memberUpdateRequestDTO.setMemberName("test2");
        memberUpdateRequestDTO.setMemberPassword("gyu123!@#");
        memberService.updateMemberInfo(memberUpdateRequestDTO);
    }
}
