package kr.co.sist.aak.module.instructor.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.aak.domain.instructor.InstructorInfoDomain;
import kr.co.sist.aak.domain.instructor.RejectDomain;
import kr.co.sist.aak.domain.instructor.vo.InstructorInfoVO;
import kr.co.sist.aak.module.instructor.dashboard.service.DashboardService;

@Controller
public class DashboardController {
	
	@Autowired(required = false)
	private DashboardService dbs;

	
	//@GetMapping("/instructor/instructorInfo.do")
	@RequestMapping(value="/instructor/instructor_home.do",method = {RequestMethod.GET, RequestMethod.POST})
	public String instructorInfo( Model model) {
		String inst_id=(String)model.getAttribute("inst_id");
		
		inst_id="INST_00005";
		
		System.out.println("---------"+inst_id);
		InstructorInfoDomain instd=dbs.lectureInfo(inst_id); 
		
		System.out.println("-=---------------------------"+instd);
		int noReplyCnt=dbs.noreply(inst_id);
		int totalCnt=dbs.totalCnt(inst_id);
		int openCnt=dbs.openCnt(inst_id);
		List<RejectDomain> recList= dbs.rejectList(inst_id);
		
		model.addAttribute("instd", instd);
		model.addAttribute("noReplyCnt", noReplyCnt);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("openCnt", openCnt);
		model.addAttribute("recList", recList);
		
		return "instructor/index";
	}//instructorInfo
	
	
	@GetMapping("/instructor/instructorInfo.do")
	public String modifyInstInfo(String inst_id, Model model) {

		return "instructor/instructorInfo";
	}
	

	@GetMapping("/instructor/lectureManage/rejectList.do")
	public String rejectList(Model model) {
		
		
		return "instructor/lectureManage/rejectList";
	}
	
	@PostMapping("/instructor/instructorInfoProcess.do")
	public String instInfoProcess(InstructorInfoVO iiVO, Model model) {
//		System.out.println("-------qnaAnswerProcess-------"+qVO);
		String inst_id=(String)model.getAttribute("inst_id");
		
		iiVO.getInst_id();
		dbs.instInfo(iiVO);
		
		return "forward:/instructor/instructorInfo"; 
	}  
	
	

}
