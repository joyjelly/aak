package kr.co.sist.aak.domain.student.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InterestLectureVO {

	private String catName, subTitle, name; 
	private char interest;
	
}
