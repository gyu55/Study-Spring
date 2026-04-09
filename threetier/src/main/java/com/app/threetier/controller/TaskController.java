package com.app.threetier.controller;


import com.app.threetier.domain.vo.TaskVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks/*")
@RequiredArgsConstructor
public class TaskController {
    @GetMapping("/register")
    public void goToRegister(Model model){
        model.addAttribute("task", new TaskVO());
    }
//    @PostMapping("/register-ok")
//    public RedirectView registerOk(TaskVO taskVO){
//        return new RedirectView("/tasks/result");
//    }
    /*@GetMapping("/result")
    public void goToResult(Model model){
        model.addAttribute("task", new TaskVO());
    }*/

    @PostMapping("/result")
    public void resultOk(TaskVO taskVO, Model model){
        int total = taskVO.getKor() + taskVO.getEng() + taskVO.getMath();
        double avg = (double)total / 3;

        model.addAttribute("task", taskVO);
        model.addAttribute("total", total);
        model.addAttribute("avg", avg);

    }
}
