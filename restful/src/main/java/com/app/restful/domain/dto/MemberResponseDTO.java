package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberResponseDTO {
    private Long id;
    private String memberName;
    private String memberEmail;

//    정적 팩토리 메서드
//    생성자로 건들지 않음 -> 생성자가 뭘 해주는지 모름
    public static MemberResponseDTO from(MemberVO memberVO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        return memberResponseDTO;
    }
}
