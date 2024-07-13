package kr.co.sist.aak.module.student.myPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.InterestLectureVO;
import kr.co.sist.aak.module.student.myPage.repository.InterestLectureRepository;

@Service
public class InterestLectureService {

	@Autowired
	private InterestLectureRepository interestLectureRepository;
	
	public List<InterestLectureVO> getInterestLectureList(String stdId) {
        return interestLectureRepository.selectInterestLectureList(stdId);
    }

}
