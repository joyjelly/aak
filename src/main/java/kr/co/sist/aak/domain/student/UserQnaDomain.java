package kr.co.sist.aak.domain.student;

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
public class UserQnaDomain {

	private String qna_no, title, std_id, q_content, status;//content as q_content
	private String id, a_content;//content as a_content
	private Date q_date, ans_date;
	
}
