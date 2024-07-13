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
public class UserLectureDomain {

	private String sub_code, intro, goal, status, image;
	private int total_no, total_time, comp_time;
	private Date create_date;
	private String sub_title, cat_code;
	private String inst_id;
	

	private String lec_code, lec_title, f_name, lec_explain;//title as lec_title
	private int time;
	

	private String title,content, lec_status;
	private Date write_date;
	

	private String qna_no, Question_title, Q_std_id, Q_content, 
	Q_lec_code, Q_status, ans_content;//title as Q_title
	private Date q_date, ans_date; 
	private int cnt;
}
