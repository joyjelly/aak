package kr.co.sist.aak.module.student.notice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.student.UserNoticeDomain;
import kr.co.sist.aak.module.student.notice.service.UserNoticeService;

@Controller
public class UserNoticeController {

	@Autowired(required = false)
	private UserNoticeService uns;
	
	@GetMapping("/site_notice.do")
	public String searchUserNotice(Model model) {
		
		/* List<UserNoticeDomain> list = uns.searchUserNotice(); */
		model.addAttribute("list",uns.searchUserNotice());
		
		return "student/site/notice";
	}
	
//	@GetMapping("/site_notice_detail.do")
//	public String detailNotice(UserNoticeDomain und, String title, Model model) {
//		
//		und=uns.searchUserNoticeDetail(title);
//		model.addAttribute("und");
//		return "student/site/notice_detail";
//	}
	@GetMapping("/site_notice_detail.do")
	public String detailNotice(@RequestParam("title") String title, Model model) {
	    UserNoticeDomain und = uns.searchUserNoticeDetail(title);
	    model.addAttribute("und", und);
	    return "student/site/notice_detail";
	} 
	
	/*
	 * @GetMapping("manage_notification.do") public String searchNoticeList(Model
	 * model) { model.addAttribute("list", uns.search); return
	 * "/admin/manage_notification"; }
	 */
	
}
