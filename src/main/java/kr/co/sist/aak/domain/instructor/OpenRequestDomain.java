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
public class OpenRequestDomain {

	private String sub_code, lec_code, sub_title, intro, goal, image, lec_name;
	private int total_no, total_time, lesson;
	private Date create_date;
}
