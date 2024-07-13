package kr.co.sist.aak.module.admin.noticeManagement.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.admin.NoticeManagementDomain;
import kr.co.sist.aak.domain.admin.vo.NoticeManagementVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class NoticeManagementDAO {
	private NoticeManagementDAO() {

	}
	public List<NoticeManagementDomain> selectAllNotice() throws PersistenceException {
		List<NoticeManagementDomain> list = null;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.admin.selectAllAdminNotice");
		mbDAO.closeHanlder(ss);
		return list;
	}

	public List<NoticeManagementDomain> selectNoticeStatus(int status) throws PersistenceException {
		List<NoticeManagementDomain> list = null;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.admin.dynamicNotificaionStatus", status);
		mbDAO.closeHanlder(ss);
		return list;
	}

	public NoticeManagementDomain selectOneNotice(String noti_num) throws PersistenceException {
		NoticeManagementDomain nDomain = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		nDomain = ss.selectOne("kr.co.sist.aak.admin.selectOneAdminNotice", noti_num);
		mbDAO.closeHanlder(ss);
		return nDomain;

	}

	public String selectMaxValue() throws PersistenceException {
		String noti_no = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		noti_no = ss.selectOne("kr.co.sist.aak.admin.selectAdminNoticeMaxval");
		mbDAO.closeHanlder(ss);
		return noti_no;

	}

	public int insertNotice(NoticeManagementVO nVO) throws PersistenceException {
		int cnt = 0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt = ss.insert("kr.co.sist.aak.admin.insertAdminNotice", nVO);
		if (cnt == 1) {
			ss.commit();
		}
		mbDAO.closeHanlder(ss);
		return cnt;
	}

	public int updateNotice(NoticeManagementVO nVO) throws PersistenceException {
		int cnt = 0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt = ss.update("kr.co.sist.aak.admin.updateAdminNotice", nVO);
		if (cnt == 1) {
			ss.commit();
		}
		mbDAO.closeHanlder(ss);
		return cnt;
	}

	public int deleteNotice(String noti_no) throws PersistenceException {
		int cnt = 0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt = ss.delete("kr.co.sist.aak.admin.deleteAdminNotice", noti_no);
		if (cnt == 1) {
			ss.commit();
		}
		mbDAO.closeHanlder(ss);
		return cnt;
	}

	public List<NoticeManagementDomain> selectNoticeTitle(String title) throws PersistenceException {
		List<NoticeManagementDomain> list = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("kr.co.sist.aak.admin.searchNotificationTitle", title);
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	public int selectResvCnt() throws PersistenceException{
	int cnt =0;
	MybatisDAO mbDAO = MybatisDAO.getInstance();
	SqlSession ss = mbDAO.getMyBatisHandler(false);
	cnt = ss.selectOne("kr.co.sist.aak.admin.selectResvCnt");
	mbDAO.closeHanlder(ss);
	return cnt;
}
	public List<NoticeManagementDomain> selectResvTitle() throws PersistenceException{
		List<NoticeManagementDomain> list = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("kr.co.sist.aak.admin.selectResvTitle");
		mbDAO.closeHanlder(ss);
		return list;
	}
	public NoticeManagementDomain selectRecentNotice() throws PersistenceException {
		NoticeManagementDomain nm =null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		String maxval =this.selectMaxValue();
		nm = ss.selectOne("kr.co.sist.aak.admin.selectRecentNotice",maxval);
		mbDAO.closeHanlder(ss);
		return nm;
	}
	public int selectCntResv()  throws PersistenceException {
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt =ss.selectOne("kr.co.sist.aak.admin.selectCntResv");
		mbDAO.closeHanlder(ss);
		return cnt;
	}
	public int selectCntPost() throws PersistenceException  {
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt =ss.selectOne("kr.co.sist.aak.admin.selectCntPost");
		mbDAO.closeHanlder(ss);
		return cnt;
	}
	public int selectCntDelt() throws PersistenceException  {
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt =ss.selectOne("kr.co.sist.aak.admin.selectCntDelt");
		mbDAO.closeHanlder(ss);
		return cnt;
	}
//	public static void main(String[] args) {
//		new NoticeManagementDAO().selectNoticeTitle("DAO");
//	}
}
