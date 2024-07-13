package kr.co.sist.aak.module.student.myPage.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.MyExamVO;
import kr.co.sist.aak.module.student.myPage.repository.MyExamRepository;

@Service
public class MyExamService {

	@Autowired
	private MyExamRepository myExamRepository;
	
	@Autowired
	private HttpSession session;
	
	public List<MyExamVO> getExam() {
		String subCode = (String) session.getAttribute("sub_code");
        return myExamRepository.selectExam(subCode);
    }
	
    public void submitExamResult(List<MyExamVO> examResults, Principal principal) {
    	String stdId = principal.getName();
        String subCode = (String) session.getAttribute("sub_code");

        for (MyExamVO examResult : examResults) {
            examResult.setStdId(stdId);
            examResult.setSubCode(subCode);
            myExamRepository.insertExamResult(examResult);
        }
    }
    
    public int getTotalScore(String stdId, String subCode) {
        return myExamRepository.selectTotalScore(stdId, subCode);
    }
    
    public boolean isExamTaken(String stdId, String subCode) {
        return myExamRepository.checkIfExamTaken(stdId, subCode);
    }

}
