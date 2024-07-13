package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.aak.module.student.lecture.service.UserLectureService;

/**
 * Desc : 마이페이지의 각 페이지를 연결하는 controller
 * @author 고한별
 * 작성일 : 2024.06.25
 */
@Controller
public class MyPageController {
	
	@Autowired(required=false)
	private UserLectureService uls;
	
	// 학생 마이페이지 --- 나의 문의
	@GetMapping("/mypage/my_question.do")
	public String question(Principal principal, Model model){
		model.addAttribute("list",uls.searchLecQna(null));
		return "student/my_page/my_question";
	}
	
}
