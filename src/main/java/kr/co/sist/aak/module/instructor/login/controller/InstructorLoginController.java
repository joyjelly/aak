package kr.co.sist.aak.module.instructor.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.aak.domain.admin.AdminPermissionDomain;
import kr.co.sist.aak.domain.instructor.InstructorLoginDomain;
import kr.co.sist.aak.domain.instructor.vo.instructorLoginVO;
import kr.co.sist.aak.module.instructor.login.service.LoginService;

@SessionAttributes("inst_id")
@Controller
public class InstructorLoginController {

	@Autowired(required = false)
	private LoginService loginService;
	
	@RequestMapping(value = "/instructor/loginProcess.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(instructorLoginVO ilVO, HttpSession session, Model model) {
		System.out.println("Controller id : " + ilVO.getInst_id());
		
		InstructorLoginDomain ilDomain = loginService.selectLogin(ilVO);
		
		PasswordEncoder pe = new BCryptPasswordEncoder(); 
		
		if(ilDomain == null) {
			model.addAttribute("error", "error.");
			return "instructor/login";
		}
		
		String codedPw = ilDomain.getPassword(); 
		String uncodedPw = ilVO.getPassword(); 
		
		Boolean matchFlag = pe.matches(uncodedPw, codedPw);
		
		if(matchFlag == true) {
			model.addAttribute("inst_id", ilDomain.getInst_id());
			return "forward:/instructor/instructor_home.do";
		} else {
			model.addAttribute("error", "error");
			return "instructor/login";
		}
		
	}//login
	
	@GetMapping("/logout.do")
	public String logout(SessionStatus ss) {
		ss.setComplete();
		return "/instructor/login";
	}
	

}
