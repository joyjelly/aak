package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.vo.PlayLectureVO;
import kr.co.sist.aak.module.student.myPage.service.PlayLectureService;

@Controller
public class PlayLectureController {
    
    @Autowired
    private PlayLectureService playLectureService;
    
    @PostMapping("/mypage/lecture_play.do")
    @ResponseBody
    public String lecturePlay(HttpSession session, Principal principal, @RequestParam double time) {
    	
        String subCode = (String) session.getAttribute("sub_code");
        String lecCode = (String) session.getAttribute("lec_code");
        String stdId = principal.getName();

        PlayLectureVO playLectureVO = new PlayLectureVO();
        playLectureVO.setSubCode(subCode);
        playLectureVO.setLecCode(lecCode);
        playLectureVO.setStdId(stdId);
        playLectureVO.setTime(time);
        
        playLectureService.logPlayTime(playLectureVO);
        
        return "success";
    }
}
