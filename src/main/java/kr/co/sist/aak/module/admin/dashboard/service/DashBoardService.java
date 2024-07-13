package kr.co.sist.aak.module.admin.dashboard.service;


import java.util.List;

import javax.print.PrintException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.admin.DashBoardDomain;
import kr.co.sist.aak.module.admin.dashboard.dao.DashBoardDAO;

@Service
public class DashBoardService {
	
	@Autowired(required = false)
	private DashBoardDAO dmDAO;
	

	public DashBoardDomain searchDataCount(){
		DashBoardDomain dbDomain = new DashBoardDomain();
		try {
			dbDomain.setAllMember_count(dmDAO.selectCountAllMember());
			dbDomain.setAllInstructor_count(dmDAO.selectCountAllInstructor());
			dbDomain.setExitMember_count(dmDAO.selectCountExitMember());
			dbDomain.setNeedChkQuestion_count(dmDAO.selectCountNeedChkQuestion());
			dbDomain.setNeedChkSubject_count(dmDAO.selectCountNeedChkSubject());
			dbDomain.setNewMember_count(dmDAO.selectCountNewSignupMebmer());
			dbDomain.setAllSubject_count(dmDAO.selectCountAllsubject());
			
			}catch (PersistenceException pe) {
				pe.printStackTrace();
			}
		
		
		return dbDomain;
	}

	
	public List<DashBoardDomain> searchCountSignupMebmer(){
		List<DashBoardDomain> list =null;
		try {
			list = dmDAO.selectCountSignupMebmer();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
	
		return list;
	}
	
	public List<DashBoardDomain> searchCountNewSubjectCount(){
		List<DashBoardDomain> list =null;
		try {
			list = dmDAO.selectCountNewSubjectCount();
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	

}
