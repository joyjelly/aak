package kr.co.sist.aak.domain.student.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDomain {

	private String stdId, password, prePass;
	private Date changeDate;
	private char delYn;
	
}
