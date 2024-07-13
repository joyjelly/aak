package kr.co.sist.aak.domain.instructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RejectDomain {

	private String sub_code, reason;
}
