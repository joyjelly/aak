package kr.co.sist.aak.module.instructor.qna.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.instructor.QnaDomain;
import kr.co.sist.aak.domain.instructor.vo.QnaVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class QnaDAO {
	public List<QnaDomain> selectQna() throws PersistenceException{
		List<QnaDomain> list= null;
		
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		list=ss.selectList("kr.co.sist.aak.instructor.qnaList");
		
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	public QnaDomain detailQna(String qna_no) throws PersistenceException{
		QnaDomain qnd= null;
		
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		qnd=ss.selectOne("kr.co.sist.aak.instructor.qnaDetail",qna_no);
		//System.out.println("DAO=-------------------" + qna_no);
		//System.out.println("DAO=-------------------" + qnd);
		
		mbDAO.closeHanlder(ss);
		
		return qnd;
		
		
	}
	
	
	public int updateAnswer(QnaVO qVO){
		int cnt = 0;
		
		MybatisDAO mbDao=MybatisDAO.getInstance();
		SqlSession ss= mbDao.getMyBatisHandler(true);
		
		System.out.println("======updateAnswer======"+qVO);
		cnt=ss.update("kr.co.sist.aak.instructor.answerQna",qVO);
		
		mbDao.closeHanlder(ss);
		
		return cnt;
		
		
	}
	
//		public List<QnaDomain> selectqnaStatus(int status) throws PersistenceException {
//			List<QnaDomain> list = null;
//
//			MybatisDAO mbDAO = MybatisDAO.getInstance();
//			SqlSession ss = mbDAO.getMyBatisHandler(false);
//
//			list = ss.select("kr.co.sist.aak.admin.dynamicNotificaionStatus", status);
//			mbDAO.closeHanlder(ss);
//			return list;
//		}
//		
//		public List<LectureDomain> selectLectureTitle(String sub_title) throws PersistenceException {
//			List<LectureDomain> list = null;
//			
//			MybatisDAO mbDAO = MybatisDAO.getInstance();
//			SqlSession ss = mbDAO.getMyBatisHandler(false);
//			
//			list = ss.selectList("kr.co.sist.aak.searchTitle", sub_title);
//			
//			mbDAO.closeHanlder(ss);
//			return list;
//		}
}

