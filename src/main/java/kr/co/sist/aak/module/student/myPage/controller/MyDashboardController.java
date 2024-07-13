package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.aak.module.student.myPage.service.MyDashboardService;

@Controller
public class MyDashboardController {

    @Autowired
    private MyDashboardService dashboardService;

    @GetMapping("/mypage/mypage_home.do")
    public String myPageHome(Principal principal, Model model) {
        String stdId = principal.getName();
        
        int totalLectureCount = dashboardService.getTotalLectureCount(stdId);
        int processLectureCount = dashboardService.getProcessLectureCount(stdId);
        int completeLectureCount = dashboardService.getCompleteLectureCount(stdId);

        model.addAttribute("totalLectureCount", totalLectureCount);
        model.addAttribute("processLectureCount", processLectureCount);
        model.addAttribute("completeLectureCount", completeLectureCount);

        return "student/my_page/home_dashboard";
    }
}
