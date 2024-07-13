package kr.co.sist.aak.domain.instructor.vo;



public class StudentListVO {
	
	private String sub_code,STD_ID,name,status,SUB_TITLE;
	private int score;
	public StudentListVO(String sub_code, String sTD_ID, String name, String status, String sUB_TITLE, int score) {
		super();
		this.sub_code = sub_code;
		this.STD_ID = sTD_ID;
		this.name = name;
		this.status = status;
		this.SUB_TITLE = sUB_TITLE;
		this.score = score;
	}
	public StudentListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public String getSTD_ID() {
		return STD_ID;
	}
	public void setSTD_ID(String sTD_ID) {
		this.STD_ID = sTD_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSUB_TITLE() {
		return SUB_TITLE;
	}
	public void setSUB_TITLE(String sUB_TITLE) {
		this.SUB_TITLE = sUB_TITLE;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentListVO [sub_code=" + sub_code + ", STD_ID=" + STD_ID + ", name=" + name + ", status=" + status
				+ ", SUB_TITLE=" + SUB_TITLE + ", score=" + score + "]";
	}
	

	
}
