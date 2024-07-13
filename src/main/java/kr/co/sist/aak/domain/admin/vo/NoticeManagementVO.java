package kr.co.sist.aak.domain.admin.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString

public class NoticeManagementVO {
	private String noti_no,title,id,content,status,image;
	private Date write_date;
}
