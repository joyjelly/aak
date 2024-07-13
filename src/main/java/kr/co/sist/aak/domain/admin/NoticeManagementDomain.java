package kr.co.sist.aak.domain.admin;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoticeManagementDomain {
	private String noti_no,title,id,content,status,image;
	private Date write_date;
}
