package kr.co.sist.aak.domain.instructor.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QnaVO {

	private String title, std_id, inst_id, sub_code, lec_code, ans_content, content,status;
	private String qna_no;
	private Date ans_date;
}
