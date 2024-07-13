package kr.co.sist.aak.domain.instructor;

import java.sql.Time;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LectureDomain {
	private String cat_code, cat_name;
	private String sub_code, intro, lec_code, title, explain, file_Nm, reason, status, sub_title;
	private int total_no, total_time;
}
 