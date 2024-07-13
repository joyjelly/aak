package kr.co.sist.aak.module.student.auth.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class JoinRepository {

	@Autowired(required = false)
	private SpringMyBatis myBatisDAO;
	
	public void insertStudent(JoinVO joinVO) {
		SqlSession ss = myBatisDAO.getMyBatisHandler(true);
		ss.insert("kr.co.sist.aak.student.auth.join.insertStudent", joinVO);
		myBatisDAO.closeHandler(ss);
	}
	
	public void insertStudentInfo(JoinVO joinVO) {
		SqlSession ss = myBatisDAO.getMyBatisHandler(true);
		ss.insert("kr.co.sist.aak.student.auth.join.insertStudentInfo", joinVO);
		myBatisDAO.closeHandler(ss);
	}

}
