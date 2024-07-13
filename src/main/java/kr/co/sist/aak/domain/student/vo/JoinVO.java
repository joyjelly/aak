package kr.co.sist.aak.domain.student.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JoinVO {

	private String stdId, name, birth, password, tel, email;
	
}
