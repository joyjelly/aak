package kr.co.sist.aak.module.student.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.module.student.auth.repository.JoinRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JoinService {
	
    private final JoinRepository joinRepository;
    private final PasswordEncoder passwordEncoder;
    
    public JoinVO create(String stdId, String name, String birth, String password, String tel, String email) {
    	JoinVO joinVO = new JoinVO();
    	
    	joinVO.setStdId(stdId);
    	joinVO.setName(name);
    	joinVO.setBirth(birth);
    	joinVO.setPassword(passwordEncoder.encode(password));
    	joinVO.setTel(tel);
    	joinVO.setEmail(email);
    	
    	this.joinRepository.insertStudentInfo(joinVO);
    	this.joinRepository.insertStudent(joinVO);

        return joinVO;
    }
	
}
