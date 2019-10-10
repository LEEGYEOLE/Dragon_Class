package sya.gyeoukgyung.info;

/**
 * ��� ������ ����� Info
 */
public class InfoDTO {
	private int infoNo; 	// ���������� ��ȣ
	private String name; 	// �̸�
	private String birth; 	// ����
	private String rrn;		// �ֹε�Ϲ�ȣ
	private String password;// ��й�ȣ
	private String tel; 	// �޴�����ȣ
	private String email; 	// �̸���
	private String address; // �ּ�
	private String entYear; // ����, �Ի�⵵
	private int deptNo; 	// �а���ȣ
	private	String deptName;	//�а��̸�
	
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
