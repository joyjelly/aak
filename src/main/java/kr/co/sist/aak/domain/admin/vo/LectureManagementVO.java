package kr.co.sist.aak.domain.admin.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class LectureManagementVO {
	
	private String 
	sub_code
	,lec_code
	,title
	,f_name
	,lec_explain;
	

	private int  time;


	public LectureManagementVO() {
		
		// TODO Auto-generated constructor stub
	}


	public LectureManagementVO(String sub_code, String lec_code, String title, String f_name, String lec_explain,
			int time) {
		super();
		this.sub_code = sub_code;
		this.lec_code = lec_code;
		this.title = title;
		this.f_name = f_name;
		this.lec_explain = lec_explain;
		this.time = time;
	}


	public String getSub_code() {
		return sub_code;
	}


	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}


	public String getLec_code() {
		return lec_code;
	}


	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getLec_explain() {
		return lec_explain;
	}


	public void setLec_explain(String lec_explain) {
		this.lec_explain = lec_explain;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	

	
}
