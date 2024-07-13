package kr.co.sist.aak.module.student.myPage.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.MyLectureVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class MyLectureRepository {

	@Autowired(required = false)
	private SpringMyBatis myBatisDAO;
	
	public List<MyLectureVO> selectProcessLectureList(String stdId) {
		List<MyLectureVO> myLectureList = null;
		SqlSession ss = myBatisDAO.getMyBatisHandler(false);
		myLectureList = ss.selectList("kr.co.sist.aak.student.mypage.my_lecture.selectProcessLectureList", stdId);
		ss.close();
		return myLectureList;
	}
	
	public List<MyLectureVO> selectCompleteLectureList(String stdId) {
		List<MyLectureVO> myLectureList = null;
		SqlSession ss = myBatisDAO.getMyBatisHandler(false);
		myLectureList = ss.selectList("kr.co.sist.aak.student.mypage.my_lecture.selectCompleteLectureList", stdId);
		ss.close();
		return myLectureList;
	}
	
}
