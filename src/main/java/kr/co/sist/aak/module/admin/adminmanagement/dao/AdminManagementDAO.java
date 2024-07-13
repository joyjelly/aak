package kr.co.sist.aak.module.admin.adminmanagement.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.admin.AdminPermissionDomain;
import kr.co.sist.aak.domain.admin.vo.AdminPermissionVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class AdminManagementDAO {

	public List<AdminPermissionDomain> selectAlladmin() throws PersistenceException {
		List<AdminPermissionDomain> list = null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.admin5.selectAllAdmin");
		mbDAO.closeHanlder(ss);
		return list;

	}
	public int insertAdmin (AdminPermissionVO apVO) throws PersistenceException{
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		cnt = ss.insert("kr.co.sist.aak.admin5.insertAdmin",apVO);
		cnt += ss.insert("kr.co.sist.aak.admin5.insertAdminPermission",apVO);
		if(cnt==2) {
			ss.commit();
		}
		
		return cnt;
	}
	public int updateAdmin(AdminPermissionVO apVO) {
		int cnt =0;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt =ss.update("kr.co.sist.aak.admin5.updatePermissions",apVO);
		ss.commit();
		mbDAO.closeHanlder(ss);
		
		return cnt;
	}
//
//	public static void main(String[] args) {
//		System.out.println(new AdminManagementDAO().selectAlladmin());
//
//	}
}
