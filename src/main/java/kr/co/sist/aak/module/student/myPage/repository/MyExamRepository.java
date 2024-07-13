package kr.co.sist.aak.module.student.myPage.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.MyExamVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class MyExamRepository {
	
	@Autowired(required = false)
	private SpringMyBatis myBatisDAO;
	
	public List<MyExamVO> selectExam(String subCode) {
		List<MyExamVO> myLectureList = null;
		SqlSession ss = myBatisDAO.getMyBatisHandler(false);
		myLectureList = ss.selectList("kr.co.sist.aak.student.mypage.exam.selectExam", subCode);
		ss.close();
		return myLectureList;
	}

	public void insertExamResult(MyExamVO examResult) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        ss.insert("kr.co.sist.aak.student.mypage.exam.insertExamResult", examResult);
        ss.close();
    }
	
	public int selectTotalScore(String stdId, String subCode) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        int grade = ss.selectOne("kr.co.sist.aak.student.mypage.exam.selectTotalScore", Map.of("stdId", stdId, "subCode", subCode));
        ss.close();
        return grade;
    }
	
	public boolean checkIfExamTaken(String stdId, String subCode) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        int count = ss.selectOne("kr.co.sist.aak.student.mypage.exam.checkIfExamTaken", Map.of("stdId", stdId, "subCode", subCode));
        ss.close();
        return count > 0;
    }
}
