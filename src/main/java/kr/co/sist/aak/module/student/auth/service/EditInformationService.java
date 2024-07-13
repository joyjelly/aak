package kr.co.sist.aak.module.student.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.module.student.auth.repository.EditInformationRepository;

@Service
public class EditInformationService {
	@Autowired
	private EditInformationRepository editInformationRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public JoinVO getInformation(String stdId) {
        return editInformationRepository.selectInformation(stdId);
    }
	
	public void updateInformation(String stdId, String password, String tel, String email) {
        JoinVO joinVO = new JoinVO();
        joinVO.setStdId(stdId);
        if (password != null && !password.isEmpty()) {
            joinVO.setPassword(passwordEncoder.encode(password));
        } else {
            joinVO.setPassword(null);
        }
        joinVO.setTel(tel);
        joinVO.setEmail(email);
        editInformationRepository.updateInformation(joinVO);
    }
}
