package kr.co.sist.aak.module.instructor.dashboard.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.instructor.InstructorInfoDomain;
import kr.co.sist.aak.domain.instructor.LectureDomain;
import kr.co.sist.aak.domain.instructor.RejectDomain;
import kr.co.sist.aak.domain.instructor.vo.InstructorInfoVO;
import kr.co.sist.aak.domain.instructor.vo.LectureVO;
import kr.co.sist.aak.domain.instructor.vo.OpenRequestVO;
import kr.co.sist.aak.domain.instructor.vo.QnaVO;
import kr.co.sist.aak.domain.student.domain.InstructorDomain;
import kr.co.sist.aak.module.instructor.dashboard.dao.DashboardDAO;

@Service
public class DashboardService {
	
	@Autowired(required = false)
	private DashboardDAO dbDAO;
	
	
	public InstructorInfoDomain lectureInfo(String inst_id) {
		InstructorInfoDomain instd=null;
		
		try {
			instd=dbDAO.instInfo(inst_id);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return instd;
	}
	
	public List<RejectDomain> rejectList(String inst_id){
		List<RejectDomain> list=null;
		
		try {
			list=dbDAO.selectRejectList(inst_id);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}
	
	public int noreply(String inst_id) {
		int noReplyCnt=0;
		
		try {
			noReplyCnt=dbDAO.noreplyCount(inst_id);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return noReplyCnt;
	}
	
	public int totalCnt(String inst_id) {
		int totalCnt=0;
		
		try {
			totalCnt=dbDAO.selectTotalCnt(inst_id);
		}catch(PersistenceException pe){
			pe.printStackTrace();
		}
		
		return totalCnt;
	}

	public int openCnt(String inst_id) {
		
		int openCnt=0;
		
		try {
			openCnt=dbDAO.selectOpenCnt(inst_id);
		}catch(PersistenceException pe){
			pe.printStackTrace();
		}
		
		return openCnt; 
	}
	
	public int instInfo(InstructorInfoVO iiVO) {
		int cnt=0;
		
		try {
			cnt=dbDAO.updateInstrucInfo(iiVO);
						
		}catch(PersistenceException pe){
			pe.printStackTrace();
		}
		return cnt;
	}
}
