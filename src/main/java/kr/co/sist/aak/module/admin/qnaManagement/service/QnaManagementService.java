package kr.co.sist.aak.module.admin.qnaManagement.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.admin.QnaManagementDomain;
import kr.co.sist.aak.domain.admin.vo.MemberManagementVO;
import kr.co.sist.aak.domain.admin.vo.QnaManagementVO;
import kr.co.sist.aak.module.admin.qnaManagement.dao.QnaManagementDAO;
@Service
public class QnaManagementService {
	@Autowired(required = false)
	private QnaManagementDAO qmDAO;
	
	public List<QnaManagementDomain> searchQna(){
		List<QnaManagementDomain> list = null;
		try {
			list=qmDAO.selectQna();
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}
	
	public List<QnaManagementDomain> searchNewQnaTitle(){
		List<QnaManagementDomain> list = null;
		try {
			list=qmDAO.selectNewQnaTitle();
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}
	
	
	public QnaManagementDomain searchDetaleQna ( String qna_no, String status) {
		QnaManagementDomain qnaDomain = null;
		try {
			if(status.equals("D")) {
			
			qnaDomain = qmDAO.selectDetalDeletedQna(qna_no);
			
			}else {

			qnaDomain = qmDAO.selectDetalQna(qna_no);

			}
			
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return qnaDomain;
	}
	
	
	public int modyifyQnaAnswer(QnaManagementVO qnaVO) {
		int cnt = 0;

		cnt=qmDAO.updateQnaAnswer(qnaVO);
		
		
		return cnt;
	}
	
	public int addQnaAnswer(QnaManagementVO qnaVO) {
		int cnt = 0;

		cnt=qmDAO.insertQnaAnswer(qnaVO);
		
		if(cnt==2) {
			cnt=1;
		}
		
		return cnt;
	}
	
	public int deleteQna(QnaManagementVO qnaVO) {
		int cnt =0 ;
		int cnt1 = 0;
		int cnt2 = 0;
		
		cnt1=qmDAO.deleteQna(qnaVO);
		cnt2=qmDAO.insertQnaDelete(qnaVO);
		
		if(cnt1+cnt2==2) {
			cnt=1;
		}	

		return cnt;
	}
	
	public String searchNewQna() {
        int cnt = 0;
        JSONObject jsonObj = new JSONObject();
        try {
        	cnt = qmDAO.selectNewQna();

            jsonObj.put("cnt", cnt);
  
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return jsonObj.toJSONString();
    }
	
	
	public String searchPreQna() {
        int n = 0;
        int y = 0;
        int d = 0;
        JSONObject jsonObj = new JSONObject();
        try {
            n = qmDAO.selectPreNQna();
            y = qmDAO.selectPreYQna();
            d = qmDAO.selectPreDQna();
            jsonObj.put("n", n);
            jsonObj.put("y", y);
            jsonObj.put("d", d);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return jsonObj.toJSONString();
    }
	
	
	
	
}
