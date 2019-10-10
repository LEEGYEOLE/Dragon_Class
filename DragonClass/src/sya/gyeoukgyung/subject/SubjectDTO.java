package sya.gyeoukgyung.subject;

public class SubjectDTO {
	private int subNo; // 과목번호
	private String subName; // 과목 이름
	private String subCode; // 과목코드
	private int deptNo; // 학과번호

	public SubjectDTO() {
	}

	public SubjectDTO(int subNo, String subName, String subCode, int deptNo) {
		this.subNo = subNo;
		this.subName = subName;
		this.subCode = subCode;
		this.deptNo = deptNo;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "SubjectDTO [subNo=" + subNo + ", subName=" + subName + ", subCode=" + subCode + ", deptNo=" + deptNo
				+ "]";
	}

}
