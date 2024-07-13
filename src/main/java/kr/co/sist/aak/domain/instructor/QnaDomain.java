package kr.co.sist.aak.domain.instructor;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QnaDomain {

	private String qna_no, sub_title, title, std_id, sub_code, lec_code, ans_content, content, subject,status;
	private Date q_date, ans_date;
}
