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
public class InstNoticeDomain {

	private String notiNo, instId, title, content, status, subCode;
	private Date writeDate;
	
}
