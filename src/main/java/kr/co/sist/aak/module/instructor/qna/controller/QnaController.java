package kr.co.sist.aak.module.instructor.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.instructor.QnaDomain;
import kr.co.sist.aak.domain.instructor.vo.QnaVO;
import kr.co.sist.aak.module.instructor.qna.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired(required = false)
	private QnaService qas;
	
	@GetMapping("/instructor/qna/qnaList.do")
	@RequestMapping(value="/instructor/qna/qnaList.do",method= {RequestMethod.GET,RequestMethod.POST})
	public String allQna(Model model) {
		
		model.addAttribute("qnaList", qas.selectAllQna());
		return "instructor/qna/qnaList";
	}
	
	
	//  instructor/qna/qnaDetail.do?qna_no=Q_SUB00001
	@GetMapping("/instructor/qna/qnaDetail.do")
	public String qnaDetail(@RequestParam(defaultValue="Q_SUB00001") String qna_no, Model model) {
		//sSystem.out.println("----------------"+qna_no);
		QnaDomain qnd=qas.qnaDetail(qna_no);
		model.addAttribute("qnd", qnd);
		
		return "instructor/qna/qnaDetail"; 
	}  
	
	@PostMapping("/instructor/qna/qnaDetailProcess.do")
	public String qnaAnswerProcess(QnaVO qVO, Model model) {
		System.out.println("-------qnaAnswerProcess-------"+qVO);
		String inst_id=(String)model.getAttribute("init_id");
		if( inst_id == null) {
			inst_id="INST_00011";
		}
		qVO.setInst_id(inst_id);
		//sSystem.out.println("----------------"+qna_no);
		qas.qnaAnswer(qVO);
		//model.addAttribute("qnd", qnd);
		
		return "forward:/instructor/qna/qnaList.do"; 
	}  
	
	
	
	
	
	
}
