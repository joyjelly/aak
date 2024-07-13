package kr.co.sist.aak.domain.student.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstructorDomain {

	private String instId, password;
	private char delYn;
	
}
