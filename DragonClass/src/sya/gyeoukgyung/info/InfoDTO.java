package sya.gyeoukgyung.info;

/**
 * 모든 유저의 공통된 Info
 */
public class InfoDTO {
	private int infoNo; 	// 유저상세정보 번호
	private String name; 	// 이름
	private String birth; 	// 생일
	private String rrn;		// 주민등록번호
	private String password;// 비밀번호
	private String tel; 	// 휴대폰번호
	private String email; 	// 이메일
	private String address; // 주소
	private String entYear; // 입학, 입사년도
	private int deptNo; 	// 학과번호
	private	String deptName;	//학과이름
	
	public InfoDTO() {
	}

	public InfoDTO(int infoNo, String name, String birth, String rrn, String password, String tel, String email,
			String address, String entYear, int deptNo) {
		this.infoNo = infoNo;
		this.name = name;
		this.birth = birth;
		this.rrn = rrn;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.entYear = entYear;
		this.deptNo = deptNo;
	}

	public int getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntYear() {
		return entYear;
	}

	public void setEntYear(String entYear) {
		this.entYear = entYear;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "InfoDTO [infoNo=" + infoNo + ", name=" + name + ", birth=" + birth + ", rrn=" + rrn + ", password="
				+ password + ", tel=" + tel + ", email=" + email + ", address=" + address + ", entYear=" + entYear
				+ ", deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}

	
}
