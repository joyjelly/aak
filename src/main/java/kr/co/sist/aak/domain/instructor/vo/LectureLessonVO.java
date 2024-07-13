package kr.co.sist.aak.domain.instructor.vo;

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
public class LectureLessonVO {

	private String sub_code, lec_code, title, lec_explain, f_name,status;
	private int table_no, time, lesson;
//	private Date create_date;
}
