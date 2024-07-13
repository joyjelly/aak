package kr.co.sist.aak.module.admin.memberManagement.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.admin.MemberManagementDomain;
import kr.co.sist.aak.domain.admin.vo.MemberManagementVO;
import kr.co.sist.aak.module.admin.memberManagement.service.MemberManagementService;


@Controller
public class MemberManagementController {
	
	@Autowired(required = false)
	private MemberManagementService mms;
	
	@GetMapping("manage_memberlist.do")
	public String searchMember(Model model) {
		List<MemberManagementDomain> list = mms.searchMember();
		model.addAttribute("memberList",list);
		

		return "/admin/manage_memberlist";
	}
	
	
	@GetMapping("manage_member_details.do")
	public String searchDetaleMember(MemberManagementDomain mmDomain, Model model, String std_id,String flag) {
		

		mmDomain = mms.searchDetaleMember(std_id);
		model.addAttribute("mmDomain", mmDomain );
		model.addAttribute("flag",flag);

		
		return "/admin/manage_member/manage_member_details";
	}
	
	
	@GetMapping("manage_member_modyify.do")
	public String modyifyMember(MemberManagementVO mmVO,Model model) {
		
		int cnt=0;	

		cnt=mms.modyifyMember(mmVO);
		model.addAttribute("cnt",cnt);
		model.addAttribute("std_id",mmVO.getStd_id());
		
		return "/admin/manage_member/manage_member_details";
	}
	
	
	
	@GetMapping("/manage_member_reason.do")
	public String searchMemberReason(MemberManagementDomain mmDomain, Model model, String std_id) {
		
		mmDomain = mms.searchMemberReason(std_id);
		model.addAttribute("mmDomain",mmDomain);
		System.out.println(mmDomain);

		return "/admin/manage_member/manage_member_reason";
	}
	
	
	
	
	

	@ResponseBody
    @RequestMapping(value = "manage_member_pre.do", method = RequestMethod.GET, 
                    produces = "application/json;charset=UTF-8")
    public String searchMembers() {
        return mms.searchMembers();
    }
	
	
	
	
	
	
	
	
	
}