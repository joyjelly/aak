package kr.co.sist.aak.domain.instructor.vo;

public class ExamVO {

	private String  SUB_CODE,CONTENT,EX_1,EX_2,EX_3,EX_4,SOLUTION;
	private int Q_NO;
	
	public String getSUB_CODE() {
		return SUB_CODE;
	}
	public void setSUB_CODE(String sUB_CODE) {
		this.SUB_CODE = sUB_CODE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		this.CONTENT = cONTENT;
	}
	public String getEX_1() {
		return EX_1;
	}
	public void setEX_1(String EX_1) {
		this.EX_1 = EX_1;
	}
	public String getEX_2() {
		return EX_2;
	}
	public void setEX_2(String EX_2) {
		this.EX_2 = EX_2;
	}
	public String getEX_3() {
		return EX_3;
	}
	public void setEX_3(String EX_3) {
		this.EX_3 = EX_3;
	}
	public String getEX_4() {
		return EX_4;
	}
	public void setEX_4(String EX_4) {
		this.EX_4 = EX_4;
	}
	public String getSOLUTION() {
		return SOLUTION;
	}
	public void setSOLUTION(String SOLUTION) {
		this.SOLUTION = SOLUTION;
	}
	public int getQ_NO() {
		return Q_NO;
	}
	public void setQ_NO(int Q_NO) {
		this.Q_NO = Q_NO;
	}
	public ExamVO(String sUB_CODE, String cONTENT, String EX_1, String EX_2, String EX_3, String EX_4, String SOLUTION,
			int Q_NO) {
		super();
		this.SUB_CODE = sUB_CODE;
		this.CONTENT = cONTENT;
		this.EX_1 = EX_1;
		this.EX_2 = EX_2;
		this.EX_3 = EX_3;
		this.EX_4 = EX_4;
		this.SOLUTION = SOLUTION;
		this.Q_NO = Q_NO;
	}
	public ExamVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ExamVO [SUB_CODE=" + SUB_CODE + ", CONTENT=" + CONTENT + ", EX_1=" + EX_1 + ", EX_2=" + EX_2 + ", EX_3="
				+ EX_3 + ", EX_4=" + EX_4 + ", SOLUTION=" + SOLUTION + ", Q_NO=" + Q_NO + "]";
	}
	
	
	
}
