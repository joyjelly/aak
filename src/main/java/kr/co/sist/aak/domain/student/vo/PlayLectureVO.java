package kr.co.sist.aak.domain.student.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlayLectureVO {
	private String subCode, lecCode, stdId;
	private double time;
}
