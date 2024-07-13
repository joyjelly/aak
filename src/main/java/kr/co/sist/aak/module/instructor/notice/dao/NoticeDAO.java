package kr.co.sist.aak.module.instructor.notice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.instructor.NoticeDomain;
import kr.co.sist.aak.domain.instructor.vo.NoticeVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class NoticeDAO {
	
	private static NoticeDAO nDAO;
	
	private NoticeDAO() {
		
	}
	
	public static NoticeDAO getInstance() {
		if(nDAO ==null) {
			nDAO = new NoticeDAO();
		}
		return nDAO;
	}
	
	
	public List<NoticeDomain> selectNotice() throws PersistenceException{
		List<NoticeDomain>list=null;
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss=mbDAO.getMyBatisHandler(false);
		list=ss.selectList("kr.co.sist.aak.instructor3.select_notice");
		mbDAO.closeHanlder(ss);
		
		
		return list;
	}
	
	
	
	
	
	public NoticeDomain selectNoticeDetail(String noti_no)throws PersistenceException{
		
		NoticeDomain NDomain = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		NDomain = ss.selectOne("kr.co.sist.aak.instructor3.notice_detail", noti_no);
		mbDAO.closeHanlder(ss);
		
		
		return NDomain;
		
	}
	
	
	
	public int updateNotice(NoticeVO nVO) {
		
		int cnt=0;
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss =mbDAO.getMyBatisHandler(true);
		cnt=ss.update("kr.co.sist.aak.instructor3.updateNotice",nVO);
		mbDAO.closeHanlder(ss);
		
		 System.out.println("NoticeVO in DAO: " + nVO.toString());
		
		return cnt;
	
	}
	
	

    public String selectLastNoticeNum() throws PersistenceException{
    	String noti_no=null;
    	MybatisDAO mbDAO=MybatisDAO.getInstance();
        SqlSession ss = mbDAO.getMyBatisHandler(false);

        noti_no= ss.selectOne("kr.co.sist.aak.instructor3.countNotice");
        mbDAO.closeHanlder(ss);
        return noti_no;
    }
	
    public int insertNotice(NoticeVO nVO)throws PersistenceException {
    	
    	int cnt=0;
    	MybatisDAO mbDAO=MybatisDAO.getInstance();
    	SqlSession ss =mbDAO.getMyBatisHandler(false);
    	cnt=ss.insert("kr.co.sist.aak.instructor3.insertNotice",nVO);
    	if(cnt==1) {
    		ss.commit();
    	}
    	
    	mbDAO.closeHanlder(ss);
    	
    	return cnt;
    }
	
	
	
	
	

}
