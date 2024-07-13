package kr.co.sist.aak.module.admin.memberManagement.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.sist.aak.domain.admin.MemberManagementDomain;
import kr.co.sist.aak.domain.admin.vo.MemberManagementVO;
import kr.co.sist.aak.module.admin.memberManagement.dao.MemberManagementDAO;
@Service
public class MemberManagementService {
	@Autowired(required = false)
	private MemberManagementDAO mmDAO;
	
	public List<MemberManagementDomain> searchMember() {
		List<MemberManagementDomain> list = null;
		try {
		list = mmDAO.selectMember()	;
	
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}
	
	
	public MemberManagementDomain searchDetaleMember(String std_id) {
		MemberManagementDomain mmDomain = null;
		try {
			mmDomain = mmDAO.selectDetaleMember(std_id);
			
			StringBuilder tel = new StringBuilder(mmDomain.getTel());
			tel.insert(3, '-');
			tel.insert(8, '-');
			
			mmDomain.setTel(tel.toString());
			
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return mmDomain;
	}
	
	public int modyifyMember(MemberManagementVO mmVO) {
		int cnt = 0; 
		
		
		String birth = mmVO.getBirth().replaceAll("\\s+", "");
		String name = mmVO.getName().replaceAll("\\s+", "");
		String email = mmVO.getEmail().replaceAll("\\s+", "");
		String tel = mmVO.getTel().replaceAll("[\\s-]+", "");
		
		if(	birth.isEmpty() || name.isEmpty() || email.isEmpty() || tel.isEmpty() ) {
			cnt=2;
		}else if(email.contains("@") && email.contains(".") && !email.endsWith(".")  ) {
			
			mmVO.setTel(tel);
			cnt=mmDAO.updateMember(mmVO);
			
		}else {
			cnt=3;
		}
		
		return cnt;
	}
	
	
	public MemberManagementDomain searchMemberReason(String std_id) {
		MemberManagementDomain mmDomain = null;
		try {
			mmDomain = mmDAO.selectMemberReason(std_id);
	
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return mmDomain;
	}
	
	
	
	public String searchMembers() {
        int n = 0;
        int p = 0;
        JSONObject jsonObj = new JSONObject();
        try {
            n = mmDAO.selectNonMember();
            p = mmDAO.selectPreMember();
            jsonObj.put("n", n);
            jsonObj.put("p", p);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return jsonObj.toJSONString();
    }
	
	
	
	
	
	
	
}
