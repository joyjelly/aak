package kr.co.sist.aak.domain.student.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserQnaVO {
	//사이트 공지
	private String qna_no, title, std_id, q_content, status;//content as q_content
	private String id, a_content;//content as a_content
	private Date q_date, ans_date;
	
	// 각 필드에 대한 getter와 setter 추가
    public String getQna_no() {
        return qna_no;
    }

    public void setQna_no(String qna_no) {
        this.qna_no = qna_no;
    }

    public String getQ_title() {
        return title;
    }

    public void setQ_title(String title) {
        this.title = title;
    }

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public String getQ_content() {
        return q_content;
    }

    public void setQ_content(String q_content) {
        this.q_content = q_content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
