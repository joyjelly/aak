package kr.co.sist.aak.domain.student.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstExamDomain {

	private String subCode, content, ex1, ex2, ex3, ex4;
	private int qNo;
	private char solution;
	
}
