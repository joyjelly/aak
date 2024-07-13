package kr.co.sist.aak.module.student.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.module.student.auth.service.EditInformationService;

@Controller
public class EditInformationController {
	
	@Autowired
	private EditInformationService editInformationService;
	
	// 학생 마이페이지 --- 개인정보수정 -- 사용자 검증 모달
	@GetMapping("/mypage/edit_information.do")
	public String information(){
		return "student/my_page/edit_information";
	}
	
	// 학생 마이페이지 --- 개인정보수정 페이지 표시
	@GetMapping("/mypage/edit_profile.do")
	public String editProfile(Principal principal, Model model) {
		String stdId = principal.getName();
		JoinVO studentInfo = editInformationService.getInformation(stdId);
		model.addAttribute("studentInfo", studentInfo);
		return "student/my_page/edit_profile";
	}
	
	// 학생 마이페이지 --- 개인정보수정 처리
    @PostMapping("/mypage/update_profile.do")
    public String updateProfile( Principal principal, @RequestParam String password,
                                @RequestParam String tel, @RequestParam String email, Model model) {
    	String stdId = principal.getName();
        editInformationService.updateInformation(stdId, password, tel, email);
        model.addAttribute("updateSuccess", true);
        return editProfile(principal, model);
    }
}
