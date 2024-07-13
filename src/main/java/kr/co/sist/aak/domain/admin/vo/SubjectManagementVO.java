package kr.co.sist.aak.domain.admin.vo;

import java.sql.Date;



public class SubjectManagementVO {
	
	private String 
	sub_code
	,sub_title
	,name
	,cat_name
	,intro
	,goal
	,status
	,sub_image
	,reason
	,comp_time
	,introduction
	,inst_image
	
	
;

	private int  total_no, total_time;
	private Date create_date;
	
	public SubjectManagementVO() {
	
		// TODO Auto-generated constructor stub
	}

	public SubjectManagementVO(String sub_code, String sub_title, String name, String cat_name, String intro,
			String goal, String status, String sub_image, String reason, String comp_time, String introduction,
			String inst_image, int total_no, int total_time, Date create_date) {
		super();
		this.sub_code = sub_code;
		this.sub_title = sub_title;
		this.name = name;
		this.cat_name = cat_name;
		this.intro = intro;
		this.goal = goal;
		this.status = status;
		this.sub_image = sub_image;
		this.reason = reason;
		this.comp_time = comp_time;
		this.introduction = introduction;
		this.inst_image = inst_image;
		this.total_no = total_no;
		this.total_time = total_time;
		this.create_date = create_date;
	}

	public String getSub_code() {
		return sub_code;
	}

	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSub_image() {
		return sub_image;
	}

	public void setSub_image(String sub_image) {
		this.sub_image = sub_image;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComp_time() {
		return comp_time;
	}

	public void setComp_time(String comp_time) {
		this.comp_time = comp_time;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getInst_image() {
		return inst_image;
	}

	public void setInst_image(String inst_image) {
		this.inst_image = inst_image;
	}

	public int getTotal_no() {
		return total_no;
	}

	public void setTotal_no(int total_no) {
		this.total_no = total_no;
	}

	public int getTotal_time() {
		return total_time;
	}

	public void setTotal_time(int total_time) {
		this.total_time = total_time;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	
}

