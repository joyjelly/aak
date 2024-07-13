package kr.co.sist.aak.module.student.myPage.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.DetailLectureVO;
import kr.co.sist.aak.module.student.myPage.repository.DetailLectureRepository;

@Service
public class DetailLectureService {

    @Autowired
    private DetailLectureRepository detailLectureRepository;

    public List<DetailLectureVO> getDetailLecture(String subCode, String StdId) {
        return detailLectureRepository.selectDetailLecture(subCode, StdId);
    }

    public DetailLectureVO getDeailLectureInfo(String subCode, HttpSession session) {
        DetailLectureVO detailLectureVO = detailLectureRepository.selectDeailLectureInfo(subCode);
        String percent = (String) session.getAttribute("percent");
        detailLectureVO.setPercent(percent);

        return detailLectureVO;
    }

    public String getLecturePlay(String subCode, String lecCode) {
        return detailLectureRepository.selectLecturePlay(subCode, lecCode);
    }
}
