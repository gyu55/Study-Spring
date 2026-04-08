package com.app.ncs.controller;


import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    @GetMapping("/join")
    public void goToJoin(MemberVO memberVO){;}

    @PostMapping("/join")
    public RedirectView join(MemberVO memberVO){
        memberMapper.insert(memberVO);
        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public void goToLogin(MemberVO memberVO){;}

    @PostMapping("/login")
    public RedirectView login(MemberVO memberVO){
        Optional<MemberVO> findMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(findMember.isPresent()){
            session.setAttribute("member", findMember.get());
            return new RedirectView("/my-page");
        }else{
            return new RedirectView("/login");
        }
    }

    @GetMapping("/my-page")
    public void goToMyPage(){;}

    @GetMapping("/update")
    public void goToUpdate(Model model){
        model.addAttribute("member", session.getAttribute("member"));
    }
    @PostMapping("/update")
    public RedirectView update(MemberVO memberVO){
        memberMapper.update(memberVO);
        Optional<MemberVO> findMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(findMember.isPresent()){
            session.setAttribute("member", findMember.get());
        }
        return new RedirectView("/my-page");
    }

    @DeleteMapping("/delete")
    public RedirectView delete(Long id){
        memberMapper.delete(id);
        return new RedirectView("/login");
    }

}
