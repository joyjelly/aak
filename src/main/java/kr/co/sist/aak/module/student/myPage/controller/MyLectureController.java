package kr.co.sist.aak.module.student.myPage.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.vo.MyLectureVO;
import kr.co.sist.aak.module.student.myPage.service.MyLectureService;

@Controller
@RequestMapping("/mypage")
public class MyLectureController {
    
    @Autowired
    private MyLectureService myLectureService;
    
    @GetMapping("/my_lecture.do")
    public String lecture() {
        return "student/my_page/my_lecture";
    }

    @GetMapping(value = "/get_lecture_data/progress.do", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MyLectureVO> getProcessLectureData(Principal principal) {
        String stdId = principal.getName();
        return myLectureService.getProcessLectureList(stdId);
    }

    @GetMapping(value = "/get_lecture_data/complete.do", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MyLectureVO> getCompleteLectureData(Principal principal) {
        String stdId = principal.getName();
        return myLectureService.getCompleteLectureList(stdId);
    }
    
    @PostMapping("/save_subcode.do")
    @ResponseBody
    public void saveSubCode(@RequestParam Map<String, String> params, HttpSession session) {
        if (params.containsKey("subCode")) {
            session.setAttribute("sub_code", params.get("subCode"));
        }
        if (params.containsKey("subTitle")) {
            session.setAttribute("sub_title", params.get("subTitle"));
        }
        if (params.containsKey("percent")) {
        	session.setAttribute("percent", params.get("percent"));
        }
    }
}