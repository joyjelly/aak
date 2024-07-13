package kr.co.sist.aak.domain.admin;


public class DashBoardDomain {
	
	private String day;
	private String count;
	
	
	private int 
	allInstructor_count,
	exitMember_count,
	allMember_count,
	newMember_count,
	allSubject_count,
	needChkSubject_count,
	needChkQuestion_count,
	signupMebmer_count,
	mostSubject,
	mostSubject_member_count;
	
	
	
	;
	
	
	
	public DashBoardDomain() {
		
	}

	public DashBoardDomain(int allInstructor_count, int exitMember_count, int allMember_count, int newMember_count,
			int allSubject_count, int needChkSubject_count, int needChkQuestion_count, int signupMebmer_count,
			int mostSubject, int mostSubject_member_count, String day, String count) {
		super();
		this.allInstructor_count = allInstructor_count;
		this.exitMember_count = exitMember_count;
		this.allMember_count = allMember_count;
		this.newMember_count = newMember_count;
		this.allSubject_count = allSubject_count;
		this.needChkSubject_count = needChkSubject_count;
		this.needChkQuestion_count = needChkQuestion_count;
		this.signupMebmer_count = signupMebmer_count;
		this.mostSubject = mostSubject;
		this.mostSubject_member_count = mostSubject_member_count;
		this.day = day;
		this.count = count;
	}

	public int getAllInstructor_count() {
		return allInstructor_count;
	}

	public void setAllInstructor_count(int allInstructor_count) {
		this.allInstructor_count = allInstructor_count;
	}

	public int getExitMember_count() {
		return exitMember_count;
	}

	public void setExitMember_count(int exitMember_count) {
		this.exitMember_count = exitMember_count;
	}

	public int getAllMember_count() {
		return allMember_count;
	}

	public void setAllMember_count(int allMember_count) {
		this.allMember_count = allMember_count;
	}

	public int getNewMember_count() {
		return newMember_count;
	}

	public void setNewMember_count(int newMember_count) {
		this.newMember_count = newMember_count;
	}

	public int getAllSubject_count() {
		return allSubject_count;
	}

	public void setAllSubject_count(int allSubject_count) {
		this.allSubject_count = allSubject_count;
	}

	public int getNeedChkSubject_count() {
		return needChkSubject_count;
	}

	public void setNeedChkSubject_count(int needChkSubject_count) {
		this.needChkSubject_count = needChkSubject_count;
	}

	public int getNeedChkQuestion_count() {
		return needChkQuestion_count;
	}

	public void setNeedChkQuestion_count(int needChkQuestion_count) {
		this.needChkQuestion_count = needChkQuestion_count;
	}

	public int getSignupMebmer_count() {
		return signupMebmer_count;
	}

	public void setSignupMebmer_count(int signupMebmer_count) {
		this.signupMebmer_count = signupMebmer_count;
	}

	public int getMostSubject() {
		return mostSubject;
	}

	public void setMostSubject(int mostSubject) {
		this.mostSubject = mostSubject;
	}

	public int getMostSubject_member_count() {
		return mostSubject_member_count;
	}

	public void setMostSubject_member_count(int mostSubject_member_count) {
		this.mostSubject_member_count = mostSubject_member_count;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DashBoardDomain [day=" + day + ", count=" + count + ", allInstructor_count=" + allInstructor_count
				+ ", exitMember_count=" + exitMember_count + ", allMember_count=" + allMember_count
				+ ", newMember_count=" + newMember_count + ", allSubject_count=" + allSubject_count
				+ ", needChkSubject_count=" + needChkSubject_count + ", needChkQuestion_count=" + needChkQuestion_count
				+ ", signupMebmer_count=" + signupMebmer_count + ", mostSubject=" + mostSubject
				+ ", mostSubject_member_count=" + mostSubject_member_count + "]";
	}

	
	
}

