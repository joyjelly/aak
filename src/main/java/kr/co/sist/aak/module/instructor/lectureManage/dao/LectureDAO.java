package kr.co.sist.aak.module.instructor.lectureManage.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.aak.domain.instructor.LectureDomain;
import kr.co.sist.aak.domain.instructor.NoticeDomain;
import kr.co.sist.aak.domain.instructor.vo.LectureLessonVO;
import kr.co.sist.aak.domain.instructor.vo.LectureVO;
import kr.co.sist.aak.util.MybatisDAO;

@Repository
public class LectureDAO {
	public List<LectureDomain> selectAllLecture()throws PersistenceException{
		List<LectureDomain> list=null;
		
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		list=ss.selectList("kr.co.sist.aak.instructor.lectureList");
		mbDAO.closeHanlder(ss);
		
		return list;
		
	}
	public List<LectureDomain> selectSubtitle(String subCode)throws PersistenceException{
		List<LectureDomain> list=null;
		
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		list=ss.selectList("kr.co.sist.aak.instructor.subtitle",subCode);
		mbDAO.closeHanlder(ss);
		
		return list;
		
	}
	
	public LectureDomain lectureDetail(String sub_code) throws PersistenceException{
		LectureDomain list=null;
		
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		list=ss.selectOne("kr.co.sist.aak.instructor.lectureDetail",sub_code);
		mbDAO.closeHanlder(ss);
		
		return list;
	}
	
	public List<LectureDomain> selectLectureStatus(int status) throws PersistenceException {
		List<LectureDomain> list = null;

		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);

		list = ss.selectList("kr.co.sist.aak.instructor", status);
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	public List<LectureDomain> selectLectureTitle(String sub_title) throws PersistenceException {
		List<LectureDomain> list = null;
		
		MybatisDAO mbDAO = MybatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.aak.instructor.searchTitle", sub_title);
		
		mbDAO.closeHanlder(ss);
		return list;
	}
	
	public LectureVO insertLecture(String sub_code)   {
		LectureVO lecVO=null;
		
		MybatisDAO mbDAO= MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		lecVO=ss.selectOne("kr.co.sist.aak.instructor.insertLecture",sub_code);
		mbDAO.closeHanlder(ss);
		
		return lecVO;
		
	}

	public LectureLessonVO lectureLesson(String sub_code)   {
		
		LectureLessonVO leclessVO=null;
		
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		leclessVO=ss.selectOne(sub_code);
		
		mbDAO.closeHanlder(ss);
		return leclessVO;
	}

	public NoticeDomain selectNotice(String sub_code)   {
		
		NoticeDomain ntd=null;
		
		MybatisDAO mbDAO=MybatisDAO.getInstance();
		SqlSession ss= mbDAO.getMyBatisHandler(false);
		
		ntd=ss.selectOne("kr.co.sist.aak.instructor.searchNotice",sub_code);
		
		mbDAO.closeHanlder(ss);
		return ntd;
	}
	
	public List<LectureDomain> selectCategory() {
		List<LectureDomain> list=null;
		
		MybatisDAO mbDao=MybatisDAO.getInstance();
		SqlSession ss= mbDao.getMyBatisHandler(false);
		
		list=ss.selectList("kr.co.sist.aak.instructor.selectCategory");
		
		mbDao.closeHanlder(ss);
		
		return list;
	}
}

