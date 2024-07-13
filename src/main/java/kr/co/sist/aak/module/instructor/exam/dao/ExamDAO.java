package kr.co.sist.aak.module.instructor.exam.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.instructor.ExamDomain;
import kr.co.sist.aak.domain.instructor.vo.ExamVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class ExamDAO {
	
	private static ExamDAO eDAO;
	
	private ExamDAO() {
		
	}
	
	public static ExamDAO getInstance(){
		if(eDAO == null) {
			eDAO=new ExamDAO();
		}
		return eDAO;
	}
	
	public List<ExamDomain> selectAllExams() throws PersistenceException {
	    List<ExamDomain> list = null;
	    MybatisDAO mbDAO = MybatisDAO.getInstance();
	    SqlSession ss = mbDAO.getMyBatisHandler(false);
	    list = ss.selectList("kr.co.sist.aak.instructor4.select_exam");
	    System.out.println("dao list:" + list);
	    mbDAO.closeHanlder(ss);
	    return list;
	}
	
	
	public List<ExamDomain> selectExamsBySubCode(String subCode) throws PersistenceException {
	    List<ExamDomain> list = null;
	    MybatisDAO mbDAO = MybatisDAO.getInstance();
	    SqlSession ss = mbDAO.getMyBatisHandler(false);
	    list = ss.selectList("kr.co.sist.aak.instructor4.select_exam_subcode", subCode);
	    mbDAO.closeHanlder(ss);
	    return list;
	}
	
	
	
	   public int insertExam(ExamVO eVO) throws PersistenceException {
	        int cnt = 0;
	        MybatisDAO mbDAO = MybatisDAO.getInstance();
	        SqlSession ss = mbDAO.getMyBatisHandler(false);
	        try {
	            cnt = ss.insert("kr.co.sist.aak.instructor4.insert_exam", eVO);
	            if (cnt == 1) {
	                ss.commit();
	            }
	        } catch (PersistenceException e) {
	            ss.rollback();
	            throw e;
	        } finally {
	            mbDAO.closeHanlder(ss);
	        }
	        System.out.println("insert의 dao" + eVO.toString());
	        return cnt;
	    }

	    
	   public int insertMultipleExams(List<ExamVO> examList) throws PersistenceException {
		    int totalCnt = 0;
		    MybatisDAO mbDAO = MybatisDAO.getInstance();
		    SqlSession ss = mbDAO.getMyBatisHandler(false);
		    try {
		        for (ExamVO eVO : examList) {
		            int cnt = ss.insert("kr.co.sist.aak.instructor4.insert_exam", eVO);
		            totalCnt += cnt;
		            System.out.println("Inserted ExamVO: " + eVO + " | Insert count: " + cnt);
		        }
		        if (totalCnt == examList.size()) {
		            ss.commit();
		        } else {
		            throw new PersistenceException("일부 문제 삽입 실패");
		        }
		    } catch (PersistenceException e) {
		        ss.rollback();
		        throw e;
		    } finally {
		        mbDAO.closeHanlder(ss);
		    }
		    System.out.println("insertMultipleExams의 dao: " + totalCnt + "개 문제 삽입");
		    return totalCnt;
		}
	
	public int selectQNum()throws PersistenceException{
		MybatisDAO mbDAO=MybatisDAO.getInstance();
        SqlSession ss = mbDAO.getMyBatisHandler(false);
        
        int Q_NO = ss.selectOne("kr.co.sist.aak.instructor4.countQNO");
        mbDAO.closeHanlder(ss);
        
        
        
        return Q_NO+1;
		
	}
	
	
	public int updateExam(ExamVO eVO) {
		int cnt=0;
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(true);
		cnt=ss.update("kr.co.sist.aak.instructor4.update_exam", eVO);
		
		System.out.println("update dao"+ eVO.toString());
		
		return cnt;
	}
	
	
	public List<ExamDomain> selectList1() throws PersistenceException {
	    List<ExamDomain> list = null;
	    MybatisDAO mbDAO = MybatisDAO.getInstance();
	    SqlSession ss = mbDAO.getMyBatisHandler(false);
	    list = ss.selectList("kr.co.sist.aak.instructor4.select_exam1");
	    System.out.println("dao list:" + list);
	    mbDAO.closeHanlder(ss);
	    return list;
	}
	
	
	

}
