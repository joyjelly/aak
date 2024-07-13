package kr.co.sist.aak.module.student.myPage.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.InterestLectureVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class InterestLectureRepository {

    @Autowired(required = false)
    private SpringMyBatis myBatisDAO;
    
    public List<InterestLectureVO> selectInterestLectureList(String stdId) {
        List<InterestLectureVO> interestLectureList = null;
        SqlSession ss = myBatisDAO.getMyBatisHandler(false);
        interestLectureList = ss.selectList("kr.co.sist.aak.student.mypage.interest.selectInterestLectureList", stdId);
        ss.close();
        return interestLectureList;
    }
}