package kr.co.sist.aak.module.student.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.aak.domain.student.vo.WithdrawalVO;
import kr.co.sist.aak.module.student.auth.service.WithdrawalService;

@Controller
public class WithdrawalController {
	
    @Autowired(required = false)
    private WithdrawalService withdrawalService;

    @RequestMapping(value = "/mypage/withdrawal_form.do", method = RequestMethod.POST)
    @ResponseBody
    public String join(Principal principal,
                       @RequestParam String reason) {
        String stdId = principal.getName();
        WithdrawalVO withdrawalVO = withdrawalService.createExitReason(stdId, reason);
        return "success";
    }


}

