package kr.co.sist.aak.module.instructor.studentList.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.instructor.StudentListDomain;
import kr.co.sist.aak.module.instructor.studentList.dao.StudentListDAO;
@Service
public class StudentListService {
	@Autowired(required = false)
	private StudentListDAO slDAO;
	
	public List<StudentListDomain> searchList(){
		List<StudentListDomain>list=null;
		try {
			list=slDAO.selectList();
			System.out.println(list);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	
	 public List<StudentListDomain> searchById(String STD_ID) throws PersistenceException {
	        return slDAO.searchid(STD_ID);
	    }

	    public List<StudentListDomain> searchBySubCode(String SUB_TITLE) throws PersistenceException {
	        return slDAO.searchsubcode(SUB_TITLE);
	    }
	   
	   public List<StudentListDomain> searchByname(String NAME)throws PersistenceException{
		   return slDAO.searchname(NAME);
	   }
	
	


}
