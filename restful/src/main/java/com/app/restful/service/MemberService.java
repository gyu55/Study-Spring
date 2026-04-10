package com.app.restful.service;

import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.vo.MemberVO;

import java.util.List;
import java.util.Optional;

// DAO와 Service는 1:1이 아님
// Service에는 사용자에게 제공해주는 Service만 만든다.

public interface MemberService {
//    회원가입
    public void join(MemberVO memberVO);

//    로그인
    public Optional<MemberVO> login(MemberVO memberVO);

//    회원 정보 조회
    public Optional<MemberResponseDTO> getMemberInfo(Long id);

//    회원 전체 조회
    public List<MemberResponseDTO> getAllMember();

//    회원 정보 변경
//    회원 비밀번호 변경(마이페이지)
//    회원 비밀번호 변경(로그인 하기 전)
//    회원 탈퇴
}
