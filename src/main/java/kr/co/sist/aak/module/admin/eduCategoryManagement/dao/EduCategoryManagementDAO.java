package kr.co.sist.aak.module.admin.eduCategoryManagement.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.aak.domain.admin.EduCategoryManagementDomain;
import kr.co.sist.aak.domain.admin.vo.EduCategoryManagementVO;
import kr.co.sist.aak.util.MybatisDAO;

@Component
public class EduCategoryManagementDAO {

	public List<EduCategoryManagementDomain> selectAllCategory() throws PersistenceException {
		List<EduCategoryManagementDomain> list = null;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.admin3.selectAllCategory");
		mbDAO.closeHanlder(ss);
		return list;

	}

	public List<EduCategoryManagementDomain> selectSubCategory(String cat_code) throws PersistenceException {
		List<EduCategoryManagementDomain> list = null;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.admin3.selectSubCat", cat_code);
		mbDAO.closeHanlder(ss);
		return list;

	}

	public int insertCategory(EduCategoryManagementVO emVO) throws PersistenceException {
		int cnt = 0;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		cnt = ss.insert("kr.co.sist.aak.admin3.insertEduCategory", emVO);
		if (cnt == 1) {
			ss.commit();
		}
		mbDAO.closeHanlder(ss);

		return cnt;

	}

	public String selectMaxvalue() throws PersistenceException {
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		String maxvalue = "";
		maxvalue = ss.selectOne("kr.co.sist.aak.admin3.selectMaxvalue");

		mbDAO.closeHanlder(ss);
		return maxvalue;
	}
	public EduCategoryManagementDomain selectCategorySubjectCount(String prime_cat_code) throws PersistenceException {
		EduCategoryManagementDomain ecm =null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		ecm = ss.selectOne("kr.co.sist.aak.admin3.categorysubCnt",prime_cat_code);
		mbDAO.closeHanlder(ss);
		return ecm;
	}
	public EduCategoryManagementDomain selectRecentCode(String cat_code) {
		EduCategoryManagementDomain ecm =null;
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		ecm = ss.selectOne("kr.co.sist.aak.admin3.selectMaxvalPrimecode",cat_code);
		mbDAO.closeHanlder(ss);
		return ecm;
	}

}
