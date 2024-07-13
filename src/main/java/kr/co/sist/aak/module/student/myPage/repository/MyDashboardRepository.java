package kr.co.sist.aak.module.student.myPage.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class MyDashboardRepository {

	@Autowired(required = false)
	private SpringMyBatis myBatisDAO;
	
	public int countTotalLecture(String stdId) {
		int count;
		SqlSession ss = myBatisDAO.getMyBatisHandler(false);
		count = ss.selectOne("kr.co.sist.aak.student.mypage.dashboard.selectTotalLectureCount", stdId);
		ss.close();
		return count;
	}
	
    public int countProcessLecture(String stdId) {
        int count;
        SqlSession ss = myBatisDAO.getMyBatisHandler(false);
        count = ss.selectOne("kr.co.sist.aak.student.mypage.dashboard.selectProcessLectureCount", stdId);
        ss.close();
        return count;
    }

    public int countCompleteLecture(String stdId) {
        int count;
        SqlSession ss = myBatisDAO.getMyBatisHandler(false);
        count = ss.selectOne("kr.co.sist.aak.student.mypage.dashboard.selectCompleteLectureCount", stdId);
        ss.close();
        return count;
    }
	
}
