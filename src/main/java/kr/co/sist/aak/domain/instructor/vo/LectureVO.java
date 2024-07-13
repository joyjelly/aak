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

public class LectureVO {

	private String sub_code, intro, goal, image, sub_title,status;
	private int total_no, total_time, comp_time;
	private Date create_date;
}
