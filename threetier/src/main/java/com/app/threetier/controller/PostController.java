package com.app.threetier.controller;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.threetier.service.PostService;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    @GetMapping("/list")
    public void goToList(Model model) {
        model.addAttribute("posts", postService.getPosts());
    }

    @GetMapping("/read")
    public void goToRead(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @GetMapping("/update")
    public void goToUpdate(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @PostMapping("/update-ok")
    public RedirectView updateOk(PostVO postVO) {
        postService.updatePost(postVO);
        return new RedirectView("/posts/read?id=" + postVO.getId());
    }

    @GetMapping("/delete-ok")
    public RedirectView goToDelete(Long id) {
        postService.deletePost(id);
        return new RedirectView("/posts/list");
    }

}
