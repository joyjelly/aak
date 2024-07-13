package kr.co.sist.aak.domain.admin;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class QnaManagementDomain {
	
	private String 
	qna_no
	,title
	,std_id
	,id
	,content_question
	,content_answer
	,status
	,reaseon;

	private Date q_date, ans_date;

	public QnaManagementDomain() {
	
	}

	public QnaManagementDomain(String qna_no, String title, String std_id, String id, String content_question,
			String content_answer, String status, String reaseon, Date q_date, Date ans_date) {
		super();
		this.qna_no = qna_no;
		this.title = title;
		this.std_id = std_id;
		this.id = id;
		this.content_question = content_question;
		this.content_answer = content_answer;
		this.status = status;
		this.reaseon = reaseon;
		this.q_date = q_date;
		this.ans_date = ans_date;
	}

	@Override
	public String toString() {
		return "QnaManagementDomain [qna_no=" + qna_no + ", title=" + title + ", std_id=" + std_id + ", id=" + id
				+ ", content_question=" + content_question + ", content_answer=" + content_answer + ", status=" + status
				+ ", reaseon=" + reaseon + ", q_date=" + q_date + ", ans_date=" + ans_date + "]";
	}

	public String getQna_no() {
		return qna_no;
	}

	public void setQna_no(String qna_no) {
		this.qna_no = qna_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent_question() {
		return content_question;
	}

	public void setContent_question(String content_question) {
		this.content_question = content_question;
	}

	public String getContent_answer() {
		return content_answer;
	}

	public void setContent_answer(String content_answer) {
		this.content_answer = content_answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReaseon() {
		return reaseon;
	}

	public void setReaseon(String reaseon) {
		this.reaseon = reaseon;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public Date getAns_date() {
		return ans_date;
	}

	public void setAns_date(Date ans_date) {
		this.ans_date = ans_date;
	}



	
}
