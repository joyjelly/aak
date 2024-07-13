package kr.co.sist.aak.module.student.auth.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.WithdrawalVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class WithdrawalRepository {

	@Autowired(required = false)
	private SpringMyBatis myBatisDAO;
	
	public void deleteStudent(String stdId) {
		SqlSession ss = myBatisDAO.getMyBatisHandler(true);
		ss.update("kr.co.sist.aak.student.auth.exit.deleteStudent", stdId);
		myBatisDAO.closeHandler(ss);
	}
	
	public void insertExitReason(WithdrawalVO withdrawalVO) {
		SqlSession ss = myBatisDAO.getMyBatisHandler(true);
		ss.insert("kr.co.sist.aak.student.auth.exit.insertExitReason", withdrawalVO);
		myBatisDAO.closeHandler(ss);
	}
}
