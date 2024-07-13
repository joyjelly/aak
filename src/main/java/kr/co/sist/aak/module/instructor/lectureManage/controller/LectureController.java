package kr.co.sist.aak.module.instructor.lectureManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.aak.domain.instructor.LectureDomain;
import kr.co.sist.aak.domain.instructor.NoticeDomain;
import kr.co.sist.aak.module.instructor.lectureManage.service.LectureService;

@Controller
public class LectureController {

	@Autowired(required = false)
	private LectureService lecs;
	
	@GetMapping("/instructor/lectureManage/lectureList.do")
	public String allLectureList(Model model) {
		
		List<LectureDomain> list=lecs.lectureAll();
		
		model.addAttribute("lecList",list);
		//System.out.println("----------------------------------"+list);
		return "instructor/lectureManage/lectureList";
	}
	
	@GetMapping("/instructor/lectureManage/lectureList_detail.do")
	public String lectureList_detail(LectureDomain lecd,  String sub_code, Model model) {
		System.out.println("--------------------------"+ sub_code);
		LectureDomain list= lecs.lectureDetail(sub_code);
		System.out.println("--------------------------"+ list);
		model.addAttribute("lecDetail",list);
		
		NoticeDomain ntd= lecs.noticeone(sub_code);
		model.addAttribute("ntd",ntd);
		
		return "instructor/lectureManage/lectureList_detail";
	}

//	@GetMapping("/instructor/lectureManage/lectureList.do")
//	public String noticeList(Model model,String sub_code) {
//		
//		NoticeDomain ntd= lecs.noticeone(sub_code);
//		model.addAttribute("ntd",ntd);
//		
//		return "instructor/lectureManage/lectureList";
//	}
	
	
}
