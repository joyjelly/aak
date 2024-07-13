package kr.co.sist.aak.module.admin.lectureManagement.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.admin.SubjectManagementDomain;
import kr.co.sist.aak.domain.admin.vo.LectureManagementVO;
import kr.co.sist.aak.domain.admin.vo.MemberManagementVO;
import kr.co.sist.aak.domain.admin.vo.QnaManagementVO;
import kr.co.sist.aak.domain.admin.vo.SubjectManagementVO;
import kr.co.sist.aak.domain.admin.LectureManagementDomain;
import kr.co.sist.aak.domain.admin.MemberManagementDomain;
import kr.co.sist.aak.module.admin.lectureManagement.dao.LectureManagementDAO;


@Service
public class LectureManagementService{
	@Autowired(required = false)
	private LectureManagementDAO lmDAO;
	
	public List<SubjectManagementDomain> searchSubject(){
		List<SubjectManagementDomain> list = null;
		try {
			list = lmDAO.selectSubject()	;
		
			}catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			
			return list;
	}
	
	public SubjectManagementDomain searchDetaleSubject(String sub_code) {
		SubjectManagementDomain smDomain = null;
		try {
			smDomain = lmDAO.selectDetaleSubject(sub_code);
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return smDomain;
	}
	
	public List<LectureManagementDomain> searchLecture(String sub_code) {
		List<LectureManagementDomain> lecList = null;
		try {
			lecList = lmDAO.selectLecture(sub_code);
			
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return lecList;
	}
	
	public int modyifySubject(SubjectManagementVO smVO) {
		int cnt = 0;

		cnt=lmDAO.updateSubject(smVO);
		
		
		return cnt;
	}
	
	public int refuseSubject(SubjectManagementVO smVO) {
		
		int cnt =0 ;
		int cnt1 =0 ;
		int cnt2 = 0;
		cnt=lmDAO.updateRefuseSubject(smVO);
		cnt2=lmDAO.insertRefuseSubject(smVO);
		if(cnt1+cnt2==2) {
			cnt=1;
		}
		return cnt;
	}	
		
	public String searchPreSubject() {
        int n = 0;
        int y = 0;
        int d = 0;
        JSONObject jsonObj = new JSONObject();
        try {
            n = lmDAO.selectPreNSubject();
            y = lmDAO.selectPreYSubject();
            d = lmDAO.selectPreDSubject();
            jsonObj.put("n", n);
            jsonObj.put("y", y);
            jsonObj.put("d", d);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return jsonObj.toJSONString();
    }
	
	
	
	
	
}
