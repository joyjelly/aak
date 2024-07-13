package kr.co.sist.aak.module.admin.memberManagement.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.admin.MemberManagementDomain;
import kr.co.sist.aak.domain.admin.vo.MemberManagementVO;
import kr.co.sist.aak.util.MybatisDAO;
@Component
public class MemberManagementDAO {
	
	private static MemberManagementDAO memDAO;
	
	private MemberManagementDAO() {
		
	}

	public static MemberManagementDAO getInstance() {
		if(memDAO == null) {
			memDAO = new MemberManagementDAO();
		}
		return memDAO;
	}
	


	public List<MemberManagementDomain> selectMember()throws PersistenceException {
		List<MemberManagementDomain> list = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		list = ss.selectList("kr.co.sist.aak.admin4.selectMember");
		mbDAO.closeHanlder(ss);
		
		
		
		return list;
	
	}
	
	
	public MemberManagementDomain selectDetaleMember(String std_id)throws PersistenceException {
		
		MemberManagementDomain mmDomain = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		mmDomain = ss.selectOne("kr.co.sist.aak.admin4.selectDetaleMember", std_id);
		mbDAO.closeHanlder(ss);
		
		
		
		return mmDomain;
	
	}

	public int updateMember(MemberManagementVO mmVO)throws PersistenceException {
	
		int cnt = 0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(true);
		cnt = ss.update("kr.co.sist.aak.admin4.updateMember",mmVO);
		mbDAO.closeHanlder(ss);
		

		return cnt;
		
	}
	
	
	public MemberManagementDomain selectMemberReason(String std_id)throws PersistenceException{
		MemberManagementDomain mmDomain = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		mmDomain = ss.selectOne("kr.co.sist.aak.admin4.MemberReason", std_id);
		mbDAO.closeHanlder(ss);
		return mmDomain;
		
	}
	
	
	
	
	
	
	
	
	public int selectNonMember()throws PersistenceException{
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		cnt = ss.selectOne("kr.co.sist.aak.admin4.nonMember");
		mbDAO.closeHanlder(ss);
		return cnt;
		
	}
	
	public int selectPreMember()throws PersistenceException{
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		cnt = ss.selectOne("kr.co.sist.aak.admin4.preMember");
		mbDAO.closeHanlder(ss);
		return cnt;
		
	}
	
	
	
	
}
