package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "회원 정보")
public class MemberResponseDTO {
    @Schema(description = "회원 번호", required = true, example = "1")
    private Long id;
    @Schema(description = "회원 이름", example = "홍길동")
    private String memberName;
    @Schema(description = "회원 이메일", required = true, example = "test@gmail.com")
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
