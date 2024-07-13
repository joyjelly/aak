package kr.co.sist.aak.module.admin.noticeManagement.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.sist.aak.domain.admin.NoticeManagementDomain;
import kr.co.sist.aak.domain.admin.vo.NoticeManagementVO;
import kr.co.sist.aak.module.admin.noticeManagement.dao.NoticeManagementDAO;

@Service
public class NoticeManagementService {
	@Autowired(required = false)
	private NoticeManagementDAO nmDAO;

	/**
	 * 
	 * @param noti_no
	 * @return
	 */
	public NoticeManagementDomain searchOneNotice(String noti_no) {
		NoticeManagementDomain nmd = null;

		try {
			nmd = nmDAO.selectOneNotice(noti_no);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return nmd;
	}

	/**
	 * 
	 * @param status
	 * @return
	 */
	public String searchNoticeStatus(int status) {
		List<NoticeManagementDomain> list = null;
		JSONObject jsonObj = new JSONObject();
		try {
			list = nmDAO.selectNoticeStatus(status);
			if (status == 3) {
				list = nmDAO.selectAllNotice();
			}
		} catch (PersistenceException pe) {
		} finally {
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			for (NoticeManagementDomain temp : list) {
				jsonTemp = new JSONObject();
				jsonTemp.put("noti_no", temp.getNoti_no());
				jsonTemp.put("write_date", sdf.format(temp.getWrite_date()));
				jsonTemp.put("title", temp.getTitle());

				String status1 = temp.getStatus();
				if (status1.equals("RESV")) {
					status1 = "ajgksi";
				} else if (status1.equals("DELT")) {
					status1 = "ajgksi";
				} else {
					status1 = "ajgksi";
				}

				jsonTemp.put("status", status1);
				jsonArr.add(jsonTemp);
			}
			jsonObj.put("list", jsonArr);
		}
		return jsonObj.toJSONString();

	}

	/**
	 * 
	 * @param title
	 * @return
	 */
	public List<NoticeManagementDomain> searchNoticeTitle(String title) {
		List<NoticeManagementDomain> list = null;

		try {
			list = nmDAO.selectNoticeTitle(title);

			if ("".equals(title)) {
				list = nmDAO.selectAllNotice();
			}

		} catch (PersistenceException pe) {
			pe.printStackTrace();

		} finally {
			for (NoticeManagementDomain temp : list) {
				if (temp.getStatus().equals("RESV")) {
					temp.setStatus("예약");
				} else if (temp.getStatus().equals("DELT")) {
					temp.setStatus("삭제");

				} else {
					temp.setStatus("게시");

				}
			}

		}

		return list;

	}

	/**
	 * 
	 * @return
	 */
	public List<NoticeManagementDomain> searchAllNotice() {
		List<NoticeManagementDomain> list = null;
		try {
			list = nmDAO.selectAllNotice();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			for (NoticeManagementDomain temp : list) {
				if (temp.getStatus().equals("RESV")) {
					temp.setStatus("예약");
				} else if (temp.getStatus().equals("DELT")) {
					temp.setStatus("삭제");

				} else {
					temp.setStatus("게시");

				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @return
	 */
	public String searchMaxNoticeVal() {
		String maxVal = "";

		StringBuffer pre = new StringBuffer("A_NOT");

		try {
			maxVal = nmDAO.selectMaxValue();
			int num = Integer.parseInt(maxVal.substring(6)) + 1;
			String nextVal = String.format("%05d", num);
			pre.append(nextVal);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return pre.toString();
	}

	/**
	 * 
	 * @param nVO
	 * @return
	 */
	public int addNotice(NoticeManagementVO nVO) {
		int cnt = 0;
		try {
			cnt = nmDAO.insertNotice(nVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}

	/**
	 * @param nVO
	 * @return
	 */
	public int modifyNotice(NoticeManagementVO nVO) {
		int cnt = 0;
		try {
			cnt = nmDAO.updateNotice(nVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		return cnt;
	}

	/**
	 * @param noti_no
	 * @return
	 */
	public int removeNotice(String noti_no) {
		int cnt = 0;

		try {
			cnt = nmDAO.deleteNotice(noti_no);
		} catch (PersistenceException pe) {

		}

		return cnt;

	}
	public String searchResvInfomation() {
		List<NoticeManagementDomain> list = null;
		JSONObject jsonObj = new JSONObject();
		int cnt =0;
		try {
			cnt =nmDAO.selectResvCnt();
			list = nmDAO.selectResvTitle();
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;
			boolean flag =false;
			for(NoticeManagementDomain temp:list) {
				jsonTemp = new JSONObject();
				jsonTemp.put("title", temp.getTitle());
				jsonArr.add(jsonTemp);
				flag =true;
				
			}
			jsonObj.put("list", jsonArr);
			jsonObj.put("flag", flag);
			jsonObj.put("cnt", cnt);
		}catch (PersistenceException pe) {
		pe.printStackTrace();
		}
		return jsonObj.toJSONString();
	}
	
	public String searchRecentNotice() {
	NoticeManagementDomain nm =null;
	JSONObject jsonObj = new JSONObject();
	try {
		nm =nmDAO.selectRecentNotice();
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTemp = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		jsonObj.put("title", nm.getTitle());
		jsonObj.put("write_date", sdf.format(nm.getWrite_date()));
		jsonObj.put("id", nm.getId());
		String content = nm.getContent();
		if(content.length()>9) {
			content.substring(0, 10).concat("...");
		}
		jsonObj.put("content", content);
		//jsonArr.add(jsonTemp);
		//jsonObj.put("notice", jsonArr);
	}catch (PersistenceException pe) {
		pe.printStackTrace();
	}
	return jsonObj.toJSONString();
	}
	
	public String searchStatusCnt(){
		JSONObject jsonObj = new JSONObject();
		try {
			int resv= nmDAO.selectCntResv();
			int post= nmDAO.selectCntPost();
			int delt= nmDAO.selectCntDelt();
			jsonObj.put("resv", resv);
			jsonObj.put("post", post);
			jsonObj.put("delt", delt);
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return jsonObj.toJSONString();
	}
	
	
}
