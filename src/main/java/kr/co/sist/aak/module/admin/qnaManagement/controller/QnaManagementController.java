package kr.co.sist.aak.module.admin.qnaManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.admin.QnaManagementDomain;
import kr.co.sist.aak.domain.admin.vo.QnaManagementVO;
import kr.co.sist.aak.module.admin.qnaManagement.service.QnaManagementService;

@Controller
public class QnaManagementController {
	
	@Autowired(required = false)
	private QnaManagementService qms;
	
	
	@GetMapping("/manage_qna.do")
	public String manageQna(Model model) {
		
		List<QnaManagementDomain> list = qms.searchQna();
		model.addAttribute("qnaList",list);
		
		return "/admin/manage_qna";
	}
	
	
	
	
	@GetMapping("/manage_qna_details.do")
	public String searchDetaleQna(QnaManagementDomain qnaDomain, Model model, String qna_no, String status) {
		
		qnaDomain = qms.searchDetaleQna(qna_no,status);
		model.addAttribute("qnaDomain", qnaDomain);
		
		
		return "/admin/manage_qna/manage_qna_details";
	}
	
	@PostMapping("/manage_qna_modyify.do")
	public String modyifyQnaAnswer(QnaManagementVO qnaVO, Model model) {
		int cnt =0;
		
		cnt=qms.modyifyQnaAnswer(qnaVO);
		model.addAttribute("cnt",cnt);
		model.addAttribute("qna_no",qnaVO.getQna_no());
		model.addAttribute("status",qnaVO.getStatus());
		
		return "/admin/manage_qna/manage_qna_details";
	}
	
	
	@PostMapping("/manage_qna_add.do")
	public String addQnaAnswer(QnaManagementVO qnaVO, Model model) {
		
		int cnt =0;
		
		cnt=qms.addQnaAnswer(qnaVO);
		model.addAttribute("cnt",cnt);
		model.addAttribute("qna_no",qnaVO.getQna_no());
		model.addAttribute("status",qnaVO.getStatus());
		
		return "/admin/manage_qna/manage_qna_details";
	}
	
	
	@GetMapping("/manage_qna_reason.do")
	public String reasonQna() {
	
		return "/admin/manage_qna/manage_qna_reason";
	}
	
	
	
	
	@PostMapping("/manage_qna_delete.do")
	public String deleteQna(QnaManagementVO qnaVO, Model model) {
		
		  int cnt =0;
		  System.out.println(qnaVO);
		  cnt=qms.deleteQna(qnaVO); 
		  model.addAttribute("cnt",cnt);
		  model.addAttribute("qna_no",qnaVO.getQna_no());
		 
		
		return "/admin/manage_qna/manage_qna_reason";
	}
	
	@ResponseBody
    @RequestMapping(value = "manage_qna_new.do", method = RequestMethod.GET, 
                    produces = "application/json;charset=UTF-8")
    public String searchNewQna() {
        return qms.searchNewQna();
    }
	
	@ResponseBody
    @RequestMapping(value = "manage_qna_pre.do", method = RequestMethod.GET, 
                    produces = "application/json;charset=UTF-8")
    public String searchMembers() {
        return qms.searchPreQna();
    }
	
	
}


