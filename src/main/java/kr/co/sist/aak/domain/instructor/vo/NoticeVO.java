package kr.co.sist.aak.domain.instructor.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class NoticeVO {
	private String NOTI_NO,title,INST_ID,content,status,SUB_CODE,SUB_TITLE;
	private Date write_date;
	public NoticeVO(String nOTI_NO, String title, String iNST_ID, String content, String status, String sUB_CODE,
			String sUB_TITLE, Date write_date) {
		super();
		this.NOTI_NO = nOTI_NO;
		this.title = title;
		this.INST_ID = iNST_ID;
		this.content = content;
		this.status = status;
		this.SUB_CODE = sUB_CODE;
		this.SUB_TITLE = sUB_TITLE;
		this.write_date = write_date;
	}
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNOTI_NO() {
		return NOTI_NO;
	}
	public void setNOTI_NO(String nOTI_NO) {
		this.NOTI_NO = nOTI_NO;
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
	public String getSUB_CODE() {
		return SUB_CODE;
	}
	public void setSUB_CODE(String sUB_CODE) {
		this.SUB_CODE = sUB_CODE;
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
		return "NoticeVO [NOTI_NO=" + NOTI_NO + ", title=" + title + ", INST_ID=" + INST_ID + ", content=" + content
				+ ", status=" + status + ", SUB_CODE=" + SUB_CODE + ", SUB_TITLE=" + SUB_TITLE + ", write_date="
				+ write_date + "]";
	}
	
	

}
