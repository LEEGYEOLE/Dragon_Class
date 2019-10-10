package sya.gyeoukgyung.student;

import sya.gyeoukgyung.info.InfoDTO;

/**
 * �л�����+Info 
 */
public class StudentDTO {
	private int studentNo;	//�й�
	private	int haknyun;	//�г�
	private	String status;	//��������
	private	int infoNo;		//��������ȣ
	private InfoDTO infoDTO;	//info����
	
	public StudentDTO() {
		infoDTO = new InfoDTO();
	}
	
	public StudentDTO(int studentNo, int haknyun, String status, int infoNo, InfoDTO infoDTO) {
		super();
		this.studentNo = studentNo;
		this.haknyun = haknyun;
		this.status = status;
		this.infoNo = infoNo;
		this.infoDTO = infoDTO;
	}

	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getHaknyun() {
		return haknyun;
	}
	public void setHaknyun(int haknyun) {
		this.haknyun = haknyun;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	public InfoDTO getInfoDTO() {
		return infoDTO;
	}

	public void setInfoDTO(InfoDTO infoDTO) {
		this.infoDTO = infoDTO;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentNo=" + studentNo + ", haknyun=" + haknyun + ", status=" + status + ", infoNo="
				+ infoNo + ", " + infoDTO + "]";
	}
}
