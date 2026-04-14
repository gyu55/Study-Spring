package com.app.restful.domain.vo;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
// Serializable interface: 데이터를 주고 받는 데이터라는 것을 알려주기 위함 (다른 서버와 주고 받음)
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

//    정석 팩토리 메서드
    public static MemberVO from (MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        return memberVO;
    }

    public static MemberVO from (MemberUpdateRequestDTO memberUpdateRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberUpdateRequestDTO.getId());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        return memberVO;
    }
}
