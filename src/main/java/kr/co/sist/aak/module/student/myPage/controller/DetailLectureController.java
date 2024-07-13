package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.vo.DetailLectureVO;
import kr.co.sist.aak.module.student.myPage.service.DetailLectureService;

@Controller
public class DetailLectureController {

    @Autowired
    private DetailLectureService detailLectureService;

    // 학생 마이페이지 --- 나의 강의 -- 상세
    @GetMapping("/mypage/my_lecture_detail.do")
    public String lectureDetail(Principal principal, HttpSession session, Model model) {
        String subCode = (String) session.getAttribute("sub_code");
        String stdId = principal.getName();

        List<DetailLectureVO> detailLecture = detailLectureService.getDetailLecture(subCode, stdId);
        model.addAttribute("detailLecture", detailLecture);

        DetailLectureVO detailLectureVO = detailLectureService.getDeailLectureInfo(subCode, session);
        model.addAttribute("lectureInfo", detailLectureVO);

        return "student/my_page/my_lecture_detail";
    }

    @PostMapping("/mypage/save_leccode.do")
    @ResponseBody
    public void saveLecCode(@RequestParam("lecCode") String lecCode, HttpSession session) {
        session.setAttribute("lec_code", lecCode);
    }
    
	@GetMapping("/mypage/play_lecture.do")
	public String playLecture(HttpSession session, Model model){
		String subCode = (String)session.getAttribute("sub_code");
		String lecCode = (String)session.getAttribute("lec_code");

		String fileName = detailLectureService.getLecturePlay(subCode, lecCode);
		model.addAttribute("fileName", fileName);

		return "student/my_page/play_lecture";
	}
    
    
}
