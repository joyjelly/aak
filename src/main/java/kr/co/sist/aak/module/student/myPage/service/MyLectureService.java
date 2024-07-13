package kr.co.sist.aak.module.student.myPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.MyLectureVO;
import kr.co.sist.aak.module.student.myPage.repository.MyLectureRepository;

@Service
public class MyLectureService {
	
	@Autowired
	private MyLectureRepository myLectureRepository;
	
	public List<MyLectureVO> getProcessLectureList(String stdId) {
        return myLectureRepository.selectProcessLectureList(stdId);
    }
	
	public List<MyLectureVO> getCompleteLectureList(String stdId) {
		return myLectureRepository.selectCompleteLectureList(stdId);
	}

}
