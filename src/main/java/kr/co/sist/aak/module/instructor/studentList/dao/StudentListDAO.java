package kr.co.sist.aak.module.instructor.studentList.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.instructor.StudentListDomain;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class StudentListDAO {
	
	private static StudentListDAO slDAO;
	
	private StudentListDAO() {
		
	}
	
	public static StudentListDAO getInstance() {
		if(slDAO == null) {
			slDAO = new StudentListDAO();
		}
		return slDAO;
	}
	
	
	
	public List<StudentListDomain> selectList()throws PersistenceException{
		List<StudentListDomain>list=null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss=mbDAO.getMyBatisHandler(false);
		list=ss.selectList("kr.co.sist.aak.instructor2.select_studentList_all");
		mbDAO.closeHanlder(ss);
		return list;
	}
	

	public List<StudentListDomain> searchid(String STD_ID)throws PersistenceException{
		List<StudentListDomain>list=null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss=mbDAO.getMyBatisHandler(false);
		list=ss.selectList("kr.co.sist.aak.instructor2.searchid",STD_ID);
		mbDAO.closeHanlder(ss);
		return list;
	}
	 
	public List<StudentListDomain> searchsubcode(String SUB_TITLE)throws PersistenceException{
		List<StudentListDomain>list=null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss=mbDAO.getMyBatisHandler(false);
		list=ss.selectList("kr.co.sist.aak.instructor2.searchsubcode",SUB_TITLE);
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	
	public List<StudentListDomain> searchname(String NAME)throws PersistenceException{
		List<StudentListDomain>list=null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss=mbDAO.getMyBatisHandler(false);
		list=ss.selectList("kr.co.sist.aak.instructor2.searchname",NAME);
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	
	
}
