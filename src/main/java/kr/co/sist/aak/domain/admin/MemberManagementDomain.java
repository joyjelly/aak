package kr.co.sist.aak.domain.admin;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class MemberManagementDomain {
	
	private String 
	std_id
	,name
	,password
	,pre_pass
	,birth
	,tel
	,email
	,del_yn
	,reason
	;
	
	private Date change_date, signup_date;

	public MemberManagementDomain() {
	
	}

	public MemberManagementDomain(String std_id, String name, String password, String pre_pass, String birth,
			String tel, String email, String del_yn, Date change_date, Date signup_date, String reason) {
		super();
		this.std_id = std_id;
		this.name = name;
		this.password = password;
		this.pre_pass = pre_pass;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		this.del_yn = del_yn;
		this.change_date = change_date;
		this.signup_date = signup_date;
		this.reason = reason;
	}


	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPre_pass() {
		return pre_pass;
	}

	public void setPre_pass(String pre_pass) {
		this.pre_pass = pre_pass;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "MemberManagementDomain [std_id=" + std_id + ", name=" + name + ", password=" + password + ", pre_pass="
				+ pre_pass + ", birth=" + birth + ", tel=" + tel + ", email=" + email + ", del_yn=" + del_yn
				+ ", reason=" + reason + ", change_date=" + change_date + ", signup_date=" + signup_date + "]";
	}

	

	
}
