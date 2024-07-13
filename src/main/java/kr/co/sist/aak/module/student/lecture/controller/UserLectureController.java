package kr.co.sist.aak.module.student.lecture.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.UserLectureDomain;
import kr.co.sist.aak.domain.student.vo.UserApplySubVO;
import kr.co.sist.aak.domain.student.vo.UserQnaVO;
import kr.co.sist.aak.module.student.lecture.service.UserLectureService;
import kr.co.sist.aak.module.student.notice.service.UserNoticeService;

@Controller
public class UserLectureController {

	@Autowired(required=false)
	private UserLectureService uls;
	
	@GetMapping("/lecture_list.do")
	public String searchLectureList(Model model) {
		
		model.addAttribute("listLecture",uls.searchUserLecture());
		
		return "student/lecture/lecture_list";
	}
	@GetMapping("/user_lecture_detail.do")
	public String detailLecture(@RequestParam("sub_code") String sub_code, Model model) {
		UserLectureDomain uld = uls.searchUserLectureDetail(sub_code);
		UserLectureDomain uld2 = uls.searchUserLectureDetail(sub_code);//강의 디테일
		List<UserLectureDomain> uld3 = uls.searchInstNotice(sub_code);//강의공지 리스트
		List<UserLectureDomain> uld4 = uls.searchLecture(sub_code);//강의 목차 리스트
		List<UserLectureDomain> uld5 = uls.searchLecQna(sub_code);//강의 qna 리스트
		
		
		model.addAttribute("uld",uld);
		model.addAttribute("uld2",uld2);
		model.addAttribute("uld3",uld3);
		model.addAttribute("uld4",uld4);
		model.addAttribute("uld5",uld5);
//		System.out.println("-----------------------------------------------강의 qna 리스트"+uld5);
		/* System.out.println("aaaa"+uld); */
		return "student/lecture/lecture_detail";
	}
	
	@PostMapping("/apply_subject.do")
	public String addApplySub(Principal principal, UserApplySubVO uaVO, Model model) {
		String std_id=principal.getName();
		uaVO.setStd_id(std_id);
		
		int cnt = uls.addApplySub(uaVO);
		if (cnt == 1) {
	        model.addAttribute("uqVO", uaVO);
	    }
//		System.out.println("===================uaVO========================"+uaVO);
		return "redirect:/lecture_list.do";
	}//addApplySub
	
	/*
	@ResponseBody
	@RequestMapping(value="cat_code_lecture.do",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String searchCatLecture(String cat_code) {
		System.out.println("========================================================="+cat_code);
		return uls.searchCatLecture(cat_code);
	}
	*/
	
}
