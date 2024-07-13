package kr.co.sist.aak.domain.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EduCategoryManagementDomain {
private String cat_code,cat_name,prime_cat_code;
private int subject_count;
}
