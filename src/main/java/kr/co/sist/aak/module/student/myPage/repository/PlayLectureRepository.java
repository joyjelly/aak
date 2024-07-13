package kr.co.sist.aak.module.student.myPage.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sist.aak.domain.student.vo.PlayLectureVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Repository
public class PlayLectureRepository {

    @Autowired(required = false)
    private SpringMyBatis myBatisDAO;

    public boolean existsLecturePlayTime(PlayLectureVO playLectureVO) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        boolean exists = ss.selectOne("kr.co.sist.aak.student.mypage.play_lecture.existsLecturePlayTime", playLectureVO);
        ss.close();
        return exists;
    }

    public void insertPlayTime(PlayLectureVO playLectureVO) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        ss.insert("kr.co.sist.aak.student.mypage.play_lecture.insertLecturePlayTime", playLectureVO);
        ss.close();
    }

    public void updatePlayTime(PlayLectureVO playLectureVO) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        ss.update("kr.co.sist.aak.student.mypage.play_lecture.updateLecturePlayTime", playLectureVO);
        ss.close();
    }
}
