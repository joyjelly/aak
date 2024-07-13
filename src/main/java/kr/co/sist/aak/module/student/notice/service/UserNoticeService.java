package kr.co.sist.aak.module.student.notice.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.UserNoticeDomain;
import kr.co.sist.aak.module.student.notice.dao.UserNoticeDAO;

@Service
public class UserNoticeService {

	@Autowired(required = false)
	private UserNoticeDAO unDAO;
	
	/**
	 * 공지사항 전체 리스트
	 * @return
	 */
	public List<UserNoticeDomain> searchUserNotice(){
		List<UserNoticeDomain> list = null;
		try {
		list=unDAO.selectAllUserNotice();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 공지사항 디테일
	 * @return
	 */
	public UserNoticeDomain searchUserNoticeDetail(String title){
		UserNoticeDomain und = null;
		try {
			und=unDAO.selectOneUserNotice(title);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return und;
	}
	
	public List<UserNoticeDomain> searchNoticeTitle(String title) {
		List<UserNoticeDomain> list = null;

		try {
			list = unDAO.selectNoticeTitle(title);

			if ("".equals(title)) {
				list = unDAO.selectAllUserNotice();
			}

		} catch (PersistenceException pe) {
			pe.printStackTrace();

		} 

		return list;

	}
	
}//class
