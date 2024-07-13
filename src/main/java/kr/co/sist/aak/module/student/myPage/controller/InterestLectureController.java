package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.vo.InterestLectureVO;
import kr.co.sist.aak.module.student.myPage.service.InterestLectureService;

@Controller
public class InterestLectureController {
    
    @Autowired
    private InterestLectureService interestLectureService;

    @GetMapping("/mypage/interest_lecture.do")
    public String interestLecture(Principal principal, Model model) {
        return "student/my_page/interest_lecture";
    }
    
    @GetMapping("/mypage/interest_lecture_data.do")
    @ResponseBody
    public List<InterestLectureVO> getInterestLectureData(Principal principal) {
        String stdId = principal.getName();
        return interestLectureService.getInterestLectureList(stdId);
    }
}