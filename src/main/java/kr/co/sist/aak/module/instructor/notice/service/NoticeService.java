package kr.co.sist.aak.module.instructor.notice.service;

import java.beans.Transient;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.instructor.NoticeDomain;
import kr.co.sist.aak.domain.instructor.vo.NoticeVO;
import kr.co.sist.aak.module.instructor.notice.dao.NoticeDAO;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO nDAO;
	
	public List<NoticeDomain> searchList(){
		List<NoticeDomain> list=null;
		try {
			list=nDAO.selectNotice();
			System.out.println(list);		
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	  public NoticeDomain searchdetail(String noti_no){
		NoticeDomain NDomain =null;
		
		try {
			NDomain = nDAO.selectNoticeDetail(noti_no);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return NDomain;
	  }
	 
	  
	  public int modifyNotice(NoticeVO nVO) {
	        int cnt = 0;
	        try {
	            cnt = nDAO.updateNotice(nVO);
	        } catch (PersistenceException pe) {
	            pe.printStackTrace();
	        }
	        return nDAO.updateNotice(nVO);
	    }
	  
	  
	 public int insertNotice(NoticeVO nVO) {
		 int cnt=0;
		 try {
			 cnt = nDAO.insertNotice(nVO);
		 }catch(PersistenceException e) {
			 e.printStackTrace();
		 }
		 return cnt;
	 }
	
	  
	  public String searchMaxNoticeVal() {
		  String maxVal ="";
		  
		  StringBuffer pre = new StringBuffer("I_NOT");
		  try {
		  maxVal=nDAO.selectLastNoticeNum();
		  int num= Integer.parseInt(maxVal.substring(6)+1);
		  String nextVal = String.format("%05d", num);
			 pre.append(nextVal);
		 }catch (PersistenceException e) {
			 e.printStackTrace();
		 }
		 return pre.toString();
	  }
	  
	  
	  
	  
	
	
	
}