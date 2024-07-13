package kr.co.sist.aak.domain.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InstructorManagementDomain {
private String inst_id,
name,
email,
introduction,
image,
phone,
major_subject,
education
,del_yn;
int subject_count;
double percentage;

}
