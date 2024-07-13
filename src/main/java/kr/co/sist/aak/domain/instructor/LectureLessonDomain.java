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
public class LectureLessonDomain {

	private String sub_code, lec_code, title, explain, file_Nm,status;
	private int lesson;
}
