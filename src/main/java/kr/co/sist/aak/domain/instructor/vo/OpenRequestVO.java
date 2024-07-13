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
public class OpenRequestVO {
	private String sub_code, lec_code, sub_title, intro, goal, image, lec_name, explain, video,status;
	private int total_no, total_time, lesson;
	private Date create_date;
}
