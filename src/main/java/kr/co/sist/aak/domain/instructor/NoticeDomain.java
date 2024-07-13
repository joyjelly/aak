package kr.co.sist.aak.domain.instructor;

import java.util.Date;

public class NoticeDomain { 
	
	private String noti_no,title,INST_ID,content,status,sub_code,SUB_TITLE;
	private Date write_date;
	public NoticeDomain(String noti_no, String title, String iNST_ID, String content, String status, String sub_code,
			String sUB_TITLE, Date write_date) {
		super();
		this.noti_no = noti_no;
		this.title = title;
		this.INST_ID = iNST_ID;
		this.content = content;
		this.status = status;
		this.sub_code = sub_code;
		this.SUB_TITLE = sUB_TITLE;
		this.write_date = write_date;
	}
	public NoticeDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNoti_no() {
		return noti_no;
	}
	public void setNoti_no(String noti_no) {
		this.noti_no = noti_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getINST_ID() {
		return INST_ID;
	}
	public void setINST_ID(String iNST_ID) {
		this.INST_ID = iNST_ID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public String getSUB_TITLE() {
		return SUB_TITLE;
	}
	public void setSUB_TITLE(String sUB_TITLE) {
		this.SUB_TITLE = sUB_TITLE;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	@Override
	public String toString() {
		return "NoticeDomain [noti_no=" + noti_no + ", title=" + title + ", INST_ID=" + INST_ID + ", content=" + content
				+ ", status=" + status + ", sub_code=" + sub_code + ", SUB_TITLE=" + SUB_TITLE + ", write_date="
				+ write_date + "]";
	}
	
	
	
	

}
