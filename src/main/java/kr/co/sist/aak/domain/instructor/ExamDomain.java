package kr.co.sist.aak.domain.instructor;

public class ExamDomain {
	
	private String  SUB_CODE,CONTENT,EX_1,EX_2,EX_3,EX_4,SOLUTION;
	private int Q_NO;
	
	
	public ExamDomain(String sUB_CODE, String cONTENT, String eX_1, String eX_2, String eX_3, String eX_4,
			String sOLUTION, int Q_NO) {
		super();
		this.SUB_CODE = sUB_CODE;
		this.CONTENT = cONTENT;
		this.EX_1 = eX_1;
		this.EX_2 = eX_2;
		this.EX_3 = eX_3;
		this.EX_4 = eX_4;
		this.SOLUTION = sOLUTION;
		this.Q_NO = Q_NO;
	}
	public ExamDomain() {
		super();
	}
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
	public void setEX_1(String eX_1) {
		this.EX_1 = eX_1;
	}
	public String getEX_2() {
		return EX_2;
	}
	public void setEX_2(String eX_2) {
		this.EX_2 = eX_2;
	}
	public String getEX_3() {
		return EX_3;
	}
	public void setEX_3(String eX_3) {
		this.EX_3 = eX_3;
	}
	public String getEX_4() {
		return EX_4;
	}
	public void setEX_4(String eX_4) {
		this.EX_4 = eX_4;
	}
	public String getSOLUTION() {
		return SOLUTION;
	}
	public void setSOLUTION(String sOLUTION) {
		this.SOLUTION = sOLUTION;
	}
	public int getQ_NO() {
		return Q_NO;
	}
	public void setQ_NO(int Q_NO) {
		this.Q_NO = Q_NO;
	}
	@Override
	public String toString() {
		return "ExamDomain [SUB_CODE=" + SUB_CODE + ", CONTENT=" + CONTENT + ", EX_1=" + EX_1 + ", EX_2=" + EX_2
				+ ", EX_3=" + EX_3 + ", EX_4=" + EX_4 + ", SOLUTION=" + SOLUTION + ", Q_NO=" + Q_NO + "]";
	}
	
	
	
	
	
}
