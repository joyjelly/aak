package kr.co.sist.aak.module.student.lecture.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.UserLectureDomain;
import kr.co.sist.aak.domain.student.UserNoticeDomain;
import kr.co.sist.aak.domain.student.vo.UserApplySubVO;
import kr.co.sist.aak.domain.student.vo.UserQnaVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class UserLectureDAO {

	private UserLectureDAO() {
		
	}
	
	/**
	 * 사용자 강의 리스트
	 * @return
	 */
	public List<UserLectureDomain> selectAllUserLecture(){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list=ss.selectList("kr.co.sist.aak.student3.selectAllUserLecture");
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	
	/**
	 * 강의 상세
	 * @param sub_title
	 * @return
	 */
	public UserLectureDomain selectOneUserLecture(String sub_code){
		UserLectureDomain ulDomain = null;
		
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		try {
			ulDomain=ss.selectOne("kr.co.sist.aak.student3.selectOneUserLecture", sub_code);
		}finally {
			mbDAO.closeHanlder(ss);
		}
		return ulDomain;
	}
	
	/**
	 * 강사 공지 리스트
	 * @param title
	 * @return
	 */
	public List<UserLectureDomain> selectAllInstNotice(String sub_code){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectAllInstNotice", sub_code);
		mbDAO.closeHanlder(ss);
		return list;
		
	}//selectAllInstNotice
	
	
	/**
	 * 강의 목차 리스트
	 * @param sub_code
	 * @return
	 */
	public List<UserLectureDomain> selectAllLecture(String sub_code){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectAllLecture", sub_code);
		mbDAO.closeHanlder(ss);
		return list;
		
	}//selectAllLecture
	
	/**
	 * 강의 qna 리스트
	 * @param sub_code
	 * @return
	 */
	public List<UserLectureDomain> selectAllLecQna(String sub_code){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectAllLecQna", sub_code);
		mbDAO.closeHanlder(ss);
		return list;
	}//selectAllLecture
	
	
	/**
	 * 인기강좌 상위 5개
	 * @param sub_code
	 * @return
	 */
	public List<UserLectureDomain> selectPopLecture(){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectSubcodePop");
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	/**
	 * 최신강좌 상위 3개
	 * @return
	 */
	public List<UserLectureDomain> selectLatestLecture(){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectLatestSub");
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	/**
	 * 수강신청
	 * @param uaVO
	 * @return
	 * @throws PersistenceException
	 */
	public int insertApplySubject(UserApplySubVO uaVO) throws PersistenceException {
		int cnt = 0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		cnt = ss.insert("kr.co.sist.aak.student3.insertApplySub", uaVO);
		if (cnt == 1) {
			ss.commit();
		}
		mbDAO.closeHanlder(ss);
//		System.out.println("===============cnt==================" + cnt);
		return cnt;
	}
	
	public List<UserLectureDomain> selectCatLecture(String cat_code){
		List<UserLectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.student3.selectCatLecture", cat_code);
		mbDAO.closeHanlder(ss);
		return list;
		
	}//selectAllLecture
	
	
	
}//class
