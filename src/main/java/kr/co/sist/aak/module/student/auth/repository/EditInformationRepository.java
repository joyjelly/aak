package kr.co.sist.aak.module.student.auth.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class EditInformationRepository {

    @Autowired(required = false)
    private SpringMyBatis myBatisDAO;
    
    public JoinVO selectInformation(String stdId) {
    	JoinVO joinVO = null;
        SqlSession ss = myBatisDAO.getMyBatisHandler(false);
        joinVO = ss.selectOne("kr.co.sist.aak.student.mypage.info.selectInfo", stdId);
        ss.close();
        return joinVO;
    }
    
    public void updateInformation(JoinVO joinVO) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        if (joinVO.getPassword() != null && !joinVO.getPassword().isEmpty()) {
            ss.update("kr.co.sist.aak.student.mypage.info.updatePass", joinVO);
        }
        ss.update("kr.co.sist.aak.student.mypage.info.updateInfo", joinVO);
        ss.close();
    }
	
}
