package kr.co.sist.aak.module.admin.adminmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.admin.AdminPermissionDomain;
import kr.co.sist.aak.domain.admin.vo.AdminPermissionVO;
import kr.co.sist.aak.module.admin.adminmanagement.service.AdminManagementService;


@Controller
public class AdminManagementController {
	@Autowired(required = false)
	private AdminManagementService ams;
	
	@GetMapping("manage_admin.do")
	public String searchAdminList(Model model) {
		
		List<AdminPermissionDomain> list=
				ams.searchAdmins();
		model.addAttribute("list",list);
		return "/admin/manage_admin/manage_admin";
	}
	@GetMapping("manage_adminadd.do")
	@ResponseBody
	public List<AdminPermissionDomain> searchaddedAdmin(Model model) {
		
				return ams.searchAdmins();
	}
	@PostMapping("manage_adminadd.do")
	@ResponseBody
	public String addAdmin(@ModelAttribute AdminPermissionVO apVO) {
		String key = "bys190";
		String salt ="19911031";
		TextEncryptor te = Encryptors.text(key, salt);
		apVO.setPassword(te.encrypt(apVO.getPassword()));
		ams.addAdmin(apVO);
		return "success";
	}
	@PostMapping("manage_modify.do")
	@ResponseBody
	public String modifyAdmin(@ModelAttribute AdminPermissionVO apVO) {
		ams.modifyAdmin(apVO);
		System.out.println(apVO);
		return "success";
	}
		
}
