package kr.co.sist.aak.module.instructor.qna.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.instructor.QnaDomain;
import kr.co.sist.aak.domain.instructor.vo.QnaVO;
import kr.co.sist.aak.module.instructor.qna.dao.QnaDAO;

@Service
public class QnaService {

	@Autowired(required = false)
	private QnaDAO qaDAO;
	
	public List<QnaDomain> selectAllQna(){
		
		List<QnaDomain> list= null;
		
		try {
			list=qaDAO.selectQna();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public QnaDomain qnaDetail(String qna_no) {
		QnaDomain qnd=null;
		
		try {
			qnd=qaDAO.detailQna(qna_no);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return qnd;
	}
	
	public int qnaAnswer(QnaVO qVO) {
		int cnt=0;
		
		try {
			cnt=qaDAO.updateAnswer(qVO);
						
		}catch(PersistenceException pe){
			pe.printStackTrace();
		}
		return cnt;
	}
	
}
