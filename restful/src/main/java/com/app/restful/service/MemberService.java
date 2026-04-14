package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;

import java.util.List;
import java.util.Optional;

// DAO와 Service는 1:1이 아님
// Service에는 사용자에게 제공해주는 Service만 만든다.

public interface MemberService {
//    회원가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

//    로그인
    public MemberResponseDTO login(MemberVO memberVO);

//    회원 전체 조회
    public List<MemberResponseDTO> getMemberList();

//    회원 정보 조회(ID)
    public MemberResponseDTO getMemberInfo(Long id);

//    이메일 중복 확인(버튼으로 제공하고 있다면 만들고 아니면 안 만들어도 됨)
    public void checkMemberEmailDuplicate(String memberEmail);


//    회원 정보 변경
    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO);
//    회원 비밀번호 변경(마이페이지)
//    회원 비밀번호 변경(로그인 하기 전)
//    회원 탈퇴
    public void deleteMember(Long id);
}
