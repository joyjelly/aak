package kr.co.sist.aak.module.student.lecture.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.aak.domain.student.UserLectureDomain;
import kr.co.sist.aak.domain.student.UserNoticeDomain;
import kr.co.sist.aak.domain.student.vo.UserApplySubVO;
import kr.co.sist.aak.domain.student.vo.UserQnaVO;
import kr.co.sist.aak.module.student.lecture.dao.UserLectureDAO;

@Service
public class UserLectureService {

	@Autowired(required=false)
	private UserLectureDAO ulDAO;
	
	public List<UserLectureDomain> searchUserLecture(){
		List<UserLectureDomain> list = null;
		try {
			list=ulDAO.selectAllUserLecture();
			//System.out.println("aaaaa"+list);
		} catch(PersistenceException pe) {
			pe.printStackTrace(); 
		}
		return list;
	}//searchUserLecture
	
	
	public UserLectureDomain searchUserLectureDetail(String sub_code){
		UserLectureDomain uld = null;
		try {
			uld=ulDAO.selectOneUserLecture(sub_code);
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return uld;
	}//searchUserLectureDetail
	
	public List<UserLectureDomain> searchInstNotice(String sub_code){
		List<UserLectureDomain> list = null;
		try {
		list=ulDAO.selectAllInstNotice(sub_code);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}//searchInstNotice
	
	public List<UserLectureDomain> searchLecture(String sub_code){
		List<UserLectureDomain> list = null;
		try {
			list=ulDAO.selectAllLecture(sub_code);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}//searchInstNotice
	
	public List<UserLectureDomain> searchLecQna(String sub_code){
		List<UserLectureDomain> list = null;
		try {
			list=ulDAO.selectAllLecQna(sub_code);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}//searchInstNotice
	
	public List<UserLectureDomain> searchPopLecture(){
		List<UserLectureDomain> list = null;
		try {
			list=ulDAO.selectPopLecture();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}//searchInstNotice
	
	public List<UserLectureDomain> searchLatestLecture(){
		List<UserLectureDomain> list = null;
		try {
			list=ulDAO.selectLatestLecture();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}//searchInstNotice
	
	public int addApplySub(UserApplySubVO uaVO) {
		int cnt = 0;
        try {
        	cnt = ulDAO.insertApplySubject(uaVO);
        } catch (PersistenceException Pe) {
        	Pe.printStackTrace();
        }
//        System.out.println("==============================uaVO======================="+uaVO);
        return cnt;
	}
	
	public String searchCatLecture(String cat_code){
		List<UserLectureDomain> list = null;
		JSONObject jsonObj = new JSONObject();
		try {
			list=ulDAO.selectAllLecture(cat_code);
			
		} catch (PersistenceException pe) {
		} finally {
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for (UserLectureDomain temp:list) {
				jsonTemp = new JSONObject();
				jsonTemp.put("sub_title", temp.getSub_title());
				jsonTemp.put("inst_id", temp.getInst_id());
				jsonTemp.put("image", temp.getImage());
				
				String cat = temp.getCat_code();
				if(cat.equals("CAT_000003")) {
					cat = "AAAA";
				} else if(cat.equals("CAT_000004")) {
					cat = "BBBBB";
				} else if(cat.equals("CAT_000005")) {
					cat = "JAVA";
				} else if(cat.equals("CAT_000006")) {
					cat = "C";
				}
				jsonTemp.put("cat_code", cat);
				jsonArr.add(jsonTemp);
			}
			jsonObj.put("list", jsonArr);
		}
		return jsonObj.toJSONString();
	}//searchInstNotice
	
	
	
}//class
