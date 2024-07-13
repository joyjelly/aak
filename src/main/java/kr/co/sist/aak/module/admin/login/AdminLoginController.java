package kr.co.sist.aak.module.admin.login;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.aak.domain.admin.AdminPermissionDomain;
import kr.co.sist.aak.domain.admin.DashBoardDomain;
import kr.co.sist.aak.domain.admin.QnaManagementDomain;
import kr.co.sist.aak.domain.admin.vo.AdminLoginVO;
import kr.co.sist.aak.module.admin.dashboard.service.DashBoardService;
import kr.co.sist.aak.module.admin.qnaManagement.service.QnaManagementService;
@Controller
public class AdminLoginController {
	@Autowired(required = false)
	private AdminLoginService adls;
	@Autowired(required = false)
	private DashBoardService dbs;
	@Autowired(required = false)
	private QnaManagementService qms;
	
	@RequestMapping(value = "adminindex.do",method = {RequestMethod.GET,RequestMethod.POST})
public String login(@ModelAttribute AdminLoginVO alVO,HttpSession session,Model model) {
	if(adls.searchLogin(alVO)) {
		AdminPermissionDomain ald = adls.searchAdminPermission(alVO);
	session.setAttribute("adminid", alVO.getId());
	session.setAttribute("adminPermission", ald);
	session.setAttribute("permission", ald.getPermissions());
	session.setAttribute("auth",adls.searchAuth(alVO) );
	
	
	
	DashBoardDomain dbDomain = new DashBoardDomain();
	List<DashBoardDomain> singup_list=null;
	List<DashBoardDomain> sub_List= null;
	List<QnaManagementDomain> qna_list= null;
	dbDomain = dbs.searchDataCount();
	singup_list= dbs.searchCountSignupMebmer();
	sub_List=dbs.searchCountNewSubjectCount();
	qna_list=qms.searchNewQnaTitle();
	model.addAttribute("dbDomain",dbDomain);
	model.addAttribute("singup_list",singup_list);
	model.addAttribute("qnaList",qna_list);
	model.addAttribute("sub_List",sub_List);

	
	
		return "/admin/index";
		
	}else {
		session.setAttribute("errorpage", true);
		
	}
		return "/admin/login";
}
	
	
	
	
	@GetMapping("admin_index_logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:admin_index.do";
	}
	
	
	@GetMapping("admin_main.do")
	public String toMain(Model model) {
		

		DashBoardDomain dbDomain = new DashBoardDomain();
		List<DashBoardDomain> singup_list=null;
		List<DashBoardDomain> sub_List= null;
		List<QnaManagementDomain> qna_list= null;
		dbDomain = dbs.searchDataCount();
		singup_list= dbs.searchCountSignupMebmer();
		sub_List=dbs.searchCountNewSubjectCount();
		qna_list=qms.searchNewQnaTitle();
		model.addAttribute("dbDomain",dbDomain);
		model.addAttribute("singup_list",singup_list);
		model.addAttribute("qnaList",qna_list);
		model.addAttribute("sub_List",sub_List);
		
		
		return "/admin/index";
	}
}
