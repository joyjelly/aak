package kr.co.sist.aak.module.instructor.lectureManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LectureEntranceController {
//lectureDomain, lecturelessonDomain
	@GetMapping("/instructor/lectureManage/lectureEntrance.do")
	public String lectureEntrance() {
		return "instructor/lectureManage/lectureEntrance";
	}
	
}
