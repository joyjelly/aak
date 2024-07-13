package kr.co.sist.aak.domain.student.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StdExamDomain {

	private String stdId, subCode;
	private int qNo, score, tryCount;
	private char answer;
	
}
