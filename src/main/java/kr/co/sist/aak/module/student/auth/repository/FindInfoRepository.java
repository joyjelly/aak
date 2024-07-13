package kr.co.sist.aak.module.student.auth.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.student.vo.JoinVO;
import kr.co.sist.aak.util.SpringMyBatis;

@Component
public class FindInfoRepository {

    @Autowired(required = false)
    private SpringMyBatis myBatisDAO;

    public String findIdByEmail(String email) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        String stdId = ss.selectOne("kr.co.sist.aak.student.auth.find.findIdByEmail", email);
        myBatisDAO.closeHandler(ss);
        return stdId;
    }

    public JoinVO findByEmail(String email) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        JoinVO student = ss.selectOne("kr.co.sist.aak.student.auth.find.findByEmail", email);
        myBatisDAO.closeHandler(ss);
        return student;
    }

    public void updatePassword(JoinVO joinVO) {
        SqlSession ss = myBatisDAO.getMyBatisHandler(true);
        ss.update("kr.co.sist.aak.student.auth.find.updatePassword", joinVO);
        ss.commit();
        myBatisDAO.closeHandler(ss);
    }
}
