package kr.co.sist.aak.module.student.myPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.PlayLectureVO;
import kr.co.sist.aak.module.student.myPage.repository.PlayLectureRepository;

@Service
public class PlayLectureService {

    @Autowired
    private PlayLectureRepository playLectureRepository;

    public void logPlayTime(PlayLectureVO playLectureVO) {
        boolean exists = playLectureRepository.existsLecturePlayTime(playLectureVO);
        if (exists) {
            playLectureRepository.updatePlayTime(playLectureVO);
        } else {
            playLectureRepository.insertPlayTime(playLectureVO);
        }
    }
}
