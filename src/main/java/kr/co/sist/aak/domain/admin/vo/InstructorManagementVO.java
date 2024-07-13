package kr.co.sist.aak.domain.admin.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstructorManagementVO {
	private String inst_id,name,email,introduction,image,phone,education,major_subject,del_yn,password;
}
