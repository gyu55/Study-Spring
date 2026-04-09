package com.app.threetier.controller;


import com.app.threetier.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;

@Controller
@RequestMapping("/workers/*")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/getToWork")
    public void goToGetToWork(){;}

    @PostMapping("/getToWork-ok")
    public String getToWorkOk(String name, Model model) {
        int hour = LocalTime.now().getHour();
        model.addAttribute("name", name);

        if (hour >= 9) {
            return "/workers/late";
        }
        return "/workers/getToWork";
    }

    @GetMapping("/leaveWork")
    public void goToLeaveWork(){;}

    @PostMapping("/leaveWork-ok")
    public String leaveWorkOk(String name, Model model) {
        int hour = LocalTime.now().getHour();
        model.addAttribute("name", name);

        if (hour < 17) {
            return "/workers/work"; // 17시 이전 → 업무시간
        }
        return "/workers/leaveWork"; // 정상 퇴근
    }
}
