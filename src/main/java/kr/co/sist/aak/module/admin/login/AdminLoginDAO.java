package kr.co.sist.aak.module.admin.login;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.admin.AdminLoginDomain;
import kr.co.sist.aak.domain.admin.AdminPermissionDomain;
import kr.co.sist.aak.domain.admin.vo.AdminLoginVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class AdminLoginDAO {

	
	public AdminLoginDomain selectAdminPass(AdminLoginVO alVO) throws PersistenceException{
		AdminLoginDomain ald =null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		ald =ss.selectOne("kr.co.sist.aak.admin5.loginProcess",alVO);
		return ald;
	}
	public AdminPermissionDomain selectAdminPermission(AdminLoginVO alVO)throws PersistenceException {
		AdminPermissionDomain ald =null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		ald =ss.selectOne("kr.co.sist.aak.admin5.selectAdminPermission",alVO);
		
		
		return ald ;
	}
//	public static void main(String[] args)  {
//		AdminLoginVO alVO= new AdminLoginVO();
//		alVO.setId("aaksuper");
//		
//		System.out.println(new AdminLoginDAO().selectAdminPass(alVO));
//	}
}
