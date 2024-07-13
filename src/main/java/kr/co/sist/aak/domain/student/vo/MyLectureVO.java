package kr.co.sist.aak.domain.student.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyLectureVO {
	
	private String catName, subTitle, name, status, examStatus, subCode;
	private int percent;
	
}
