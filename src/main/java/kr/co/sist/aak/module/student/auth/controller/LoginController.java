package kr.co.sist.aak.module.student.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	/**
	 * Desc : 학생의 로그인과 회원가입에 필요한 페이지로 Mapping
	 * 작성자 : 고한별
	 * 작성일 : 2024.06.23
	 * @return 로그인,회원가입 jsp의 경로
	 */
	@GetMapping("/student/login.do")
	public String login(){
		return "student/login_join";
	}
	
	
	/**
	 * Desc : 로그인 실패시 알림창 띄우고 로그인창 재 호출
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/student/login-error.do")
	public String loginError(HttpServletRequest request, Model model) {
		String error = request.getParameter("error");
		if(error != null) {
			model.addAttribute("loginError", true);
		}
		return "student/login_join";
	}
}
