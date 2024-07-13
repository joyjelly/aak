package kr.co.sist.aak.module.instructor.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sist.aak.domain.instructor.ExamDomain;
import kr.co.sist.aak.domain.instructor.vo.ExamVO;
import kr.co.sist.aak.module.instructor.exam.dao.ExamDAO;

@Service
public class ExamService {
	
	@Autowired
	private ExamDAO eDAO;
	
	public List<ExamDomain> getAllExams() {
        try {
            return eDAO.selectAllExams();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<ExamDomain> getExamsBySubCode(String subCode) {
        try {
            return eDAO.selectExamsBySubCode(subCode);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	public int insertExam(ExamVO eVO) {
		int cnt=0;
		 try {
			 cnt =  eDAO.insertExam(eVO);
		 }catch(PersistenceException e) {
			 e.printStackTrace();
		 }
		 return cnt;
		
		
	}
	
	@Transactional
	public int insertExams(List<ExamVO> examList) {
	    int result = 0;
	    for (ExamVO exam : examList) {
	        result += eDAO.insertExam(exam);
	    }
	    return result;
	}
	
	
	public int searchQNo() {
        int nextQNo = 0;
        try {
            nextQNo = eDAO.selectQNum();
            
        } catch (PersistenceException e) {
        	e.printStackTrace();
        }
        return nextQNo;
    }
	
	@Transactional
	 public int modifyExam(List<ExamVO> examList) {
       int result = 0;
       for (ExamVO exam : examList) {
           result += eDAO.updateExam(exam);
       }
       return result;
   }
	
	public List<ExamDomain>searchList1(){
		List<ExamDomain>list=null;
		try {
			list=eDAO.selectList1();
			System.out.println(list);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
}
