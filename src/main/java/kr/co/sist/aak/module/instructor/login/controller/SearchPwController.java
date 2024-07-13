
package kr.co.sist.aak.module.instructor.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchPwController {

	@GetMapping("/instructor/findPw.do")
	public String findPw() {

		return "instructor/findPw";
	}

	@GetMapping("/instructor/findProcess.do")
	public String findPw(String email, String id, String name) {

		return "instructor/findPw";
	}
}
