package kr.co.sist.aak.module.student.qna.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.student.UserQnaDomain;
import kr.co.sist.aak.domain.student.vo.UserQnaVO;
import kr.co.sist.aak.module.student.qna.service.UserQnaService;

@Controller
public class UserQnaController {

	@Autowired(required = false)
	private UserQnaService uqs;

	@GetMapping("/site_qna.do")
	public String qna(Model model) {

		model.addAttribute("list", uqs.searchSiteQna());
		/* model.addAttribute(std_id); */
		return "student/site/qna";
	}

	@GetMapping("/site_qna_detail.do")
	public String detailQna(@RequestParam("qna_no") String qna_no, Model model) {
		UserQnaDomain uqd = uqs.searchSiteDetailQ(qna_no);
		UserQnaDomain uqd2 = uqs.searchSiteDetailA(qna_no);

		model.addAttribute("uqd", uqd);
		model.addAttribute("uqd2", uqd2);

		return "student/site/qna_detail";
	}

	/*
	 * @PostMapping("/site_qna_write_process.do") public String qnaWirte(UserQnaVO
	 * uqVO, Model model) {
	 * 
	 * int cnt = 0; cnt=uqs.addSiteQ(uqVO); model.addAttribute("cnt",cnt);
	 * model.addAttribute("qna_no",uqVO.get);
	 * model.addAttribute("status",uqVO.getStatus());
	 * 
	 * System.out.println("========qnainsert=============="+uqVO); String qna_no =
	 * (String)model.getAttribute("qna_no");
	 * 
	 * uqVO.getQna_no(); uqs.addSiteQ(uqVO); return "student/site/qna"; }
	 */
	
	/*
	@PostMapping("site_qna_write_process.do")
	public String addNoticeFormProcess(HttpServletRequest request, Model model) {
	    // 1. UserQnaVO 객체를 생성하고 값을 설정한다.
	    UserQnaVO uqVO = new UserQnaVO();
	    uqVO.setTitle(request.getParameter("title"));
	    uqVO.setStd_id(request.getParameter("std_id"));uqVO.setStd_id("dowon1234");
	    uqVO.setQna_no(request.getParameter("qna_no"));
	    uqVO.setQ_content(request.getParameter("q_content"));

	    // 2. UserQnaService를 이용하여 공지사항을 추가한다.
	    int cnt = uqs.addSiteQ(uqVO);
	    if (cnt == 1) {
	        model.addAttribute("uqVO", uqVO);
	    }

	    return "student/site/qna";
	}*/
	@PostMapping("/site_qna_write_process.do")
	public String addSiteQ(Principal principal, UserQnaVO uqVO, Model model) {
		String std_id = principal.getName(); // std_id 가져오기
	    uqVO.setStd_id(std_id); // UserQnaVO에 설정
		
		// 새로운 QNA_NO 생성
	    String newQnaNo = uqs.searchMaxQVal();
	    uqVO.setQna_no(newQnaNo);

	    // 공지사항 추가
	    int cnt = uqs.addSiteQ(uqVO);
	    if (cnt == 1) {
	        model.addAttribute("uqVO", uqVO);
	    }
System.out.println("===================================================="+uqVO);
	    return "redirect:/site_qna.do"; 
	}

}