package sya.gyeoukgyung.department;

/**
 * 학과정보
 */
public class DepartmentDTO {
	private int deptNo; // 학과번호
	private String deptName; // 학과이름

	public DepartmentDTO() {
	}

	public DepartmentDTO(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
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
		this.deptName=deptName;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}

}
