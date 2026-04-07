package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/members/*") // restful
// 생성자의 매개변수로 주입 받기
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper memberMapper;

//    회원가입
    @GetMapping("/join")
//    요청 경로가 같으면 void로 생략 가능
//    public String goToJoin(){
//        return "members/join";
//    }
//    request 객체를 MemberVO를 받아서 감
//    메서드는 F.C에서 컨트롤러 쪽으로 req, res를 보냄 -> req, res를 사용할 수 있어서 자바 클래스이지만, 서블릿처럼 사용
//    req에서 사용자가 요청한 값을 받을 수 있음 -> 매개변수
    public void goToJoin(MemberVO memberVO){;}

//    값을 받아서 -> DB에 저장
    @PostMapping("/join")
    public RedirectView join(MemberVO memberVO){
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }
}
