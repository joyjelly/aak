package kr.co.sist.aak.module.student.notice.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.UserNoticeDomain;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class UserNoticeDAO {

	/* private static UserNoticeDAO unDAO; */
	
	private UserNoticeDAO() {
		
	}
	
	/*
	 * public static UserNoticeDAO getInstance() { if(unDAO==null) { unDAO=new
	 * UserNoticeDAO(); } return unDAO; }
	 */
	
	/**
	 * 사용자 공지사항 리스트
	 * @return
	 * @throws PersistenceException
	 */
	public List<UserNoticeDomain> selectAllUserNotice(){
		List<UserNoticeDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student.selectAllUserNotice");
		mbDAO.closeHanlder(ss);
		return list;
		
	}//selectAllUserNotice
	
	
	/**
	 * 사용자 공지사항 상세
	 * @return
	 */
	public UserNoticeDomain selectOneUserNotice(String title){
		UserNoticeDomain unDomain = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		try {
		unDomain = ss.selectOne("kr.co.sist.aak.student.selectOneUserNotice", title);
		}finally {
		mbDAO.closeHanlder(ss);
		}
		return unDomain;
		
	}//selectOneUserNotice
	
	
	/**
	 * @param title
	 * @return
	 * @throws PersistenceException
	 */
	public List<UserNoticeDomain> selectNoticeTitle(String title) throws PersistenceException {
		List<UserNoticeDomain> list = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("kr.co.sist.aak.student.searchNotificationTitle", title);
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	
	
	
}//class
