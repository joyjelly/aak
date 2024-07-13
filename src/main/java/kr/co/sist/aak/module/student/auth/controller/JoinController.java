package kr.co.sist.aak.module.student.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.module.student.auth.service.JoinService;

@Controller
public class JoinController {

    @Autowired(required = false)
    private JoinService joinService;

    @RequestMapping(value = "/join.do", method = RequestMethod.POST)
    public String join(@RequestParam String stdId,
                       @RequestParam String name,
                       @RequestParam String birth,
                       @RequestParam String password,
                       @RequestParam String tel,
                       @RequestParam String email) {
        
    	JoinVO joinVo = joinService.create(stdId, name, birth, password, tel, email);
    	String result = "";
    	
    	// TODO : 수정필요
    	if(joinVo != null) {
    		result = "/student/login_join";
    	}else {
    		result = "/student/home";
    	}
        
        return result;
    }
}
