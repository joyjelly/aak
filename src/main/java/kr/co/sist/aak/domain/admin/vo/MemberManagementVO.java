package kr.co.sist.aak.domain.admin.vo;



public class MemberManagementVO {
	
	private String 
	std_id
	,name
	,password
	,pre_pass
	,birth
	,tel
	,email
	,del_yn
	;

	public MemberManagementVO() {
		
	}

	public MemberManagementVO(String std_id, String name, String password, String pre_pass, String birth, String tel,
			String email, String del_yn) {
		super();
		this.std_id = std_id;
		this.name = name;
		this.password = password;
		this.pre_pass = pre_pass;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "MemberManagementVO [std_id=" + std_id + ", name=" + name + ", password=" + password + ", pre_pass="
				+ pre_pass + ", birth=" + birth + ", tel=" + tel + ", email=" + email + ", del_yn=" + del_yn + "]";
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
	

	
}
