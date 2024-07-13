package kr.co.sist.aak.module.student.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.module.student.auth.service.FindInfoService;

@Controller
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @GetMapping("/find_id_popup.do")
    public String findIdPopup() {
        return "student/find_id_popup";
    }

    @PostMapping("/findId.do")
    public String findId(@RequestParam("email") String email, Model model) {
        String username = findInfoService.findIdByEmail(email);
        if (username != null) {
            model.addAttribute("message", "가입된 아이디 : " + username);
        } else {
            model.addAttribute("error", "해당 이메일 주소로 가입된 아이디가 없습니다.");
        }
        return "student/find_id_result";
    }

    @GetMapping("/find_password_popup.do")
    public String findPasswordPopup() {
        return "student/find_password_popup";
    }

    @PostMapping("/findPassword.do")
    public String findPassword(@RequestParam("email") String email, Model model) {
        String tempPassword = findInfoService.resetPassword(email);
        if (tempPassword != null) {
            model.addAttribute("message", "임시 비밀번호 : " + tempPassword);
        } else {
            model.addAttribute("error", "해당 이메일 주소로 가입된 아이디가 없습니다.");
        }
        return "student/find_password_result";
    }
}
