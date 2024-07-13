package kr.co.sist.aak.module.student.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.WithdrawalVO;
import kr.co.sist.aak.module.student.auth.repository.WithdrawalRepository;

@Service
public class WithdrawalService {

	@Autowired
    private WithdrawalRepository withdrawalRepository;
    
    public WithdrawalVO createExitReason(String stdId, String reason) {
    	WithdrawalVO withdrawalVO = new WithdrawalVO();
    	
    	withdrawalVO.setStdId(stdId);
    	withdrawalVO.setReason(reason);
    	
    	withdrawalRepository.deleteStudent(stdId);
    	withdrawalRepository.insertExitReason(withdrawalVO);
    	
    	return withdrawalVO;
    }
}
