package kr.co.sist.aak.domain.student.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LectureDomain {
	
	private String subCode, lecCode, title, fName, lecExplain;
	private int time;
	private char status;
	
	
}
