package sya.gyeoukgyung.employee;

import sya.gyeoukgyung.info.InfoDTO;

/**
 * ����������+Info 
 */
public class EmployeeDTO {
	private int employeeNo;	//��������ȣ
	private int infoNo;	//�������󼼹�ȣ
	private int roomNo;	//�����ǹ�ȣ
	private InfoDTO infoDTO;	//info����
	
	public EmployeeDTO() {
		infoDTO = new InfoDTO();
	}
	
	
	public EmployeeDTO(int employeeNo, int infoNo, int roomNo, InfoDTO infoDTO) {
		this.employeeNo = employeeNo;
		this.infoNo = infoNo;
		this.roomNo = roomNo;
		this.infoDTO = infoDTO;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public int getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public InfoDTO getInfoDTO() {
		return infoDTO;
	}


	public void setInfoDTO(InfoDTO infoDTO) {
		this.infoDTO = infoDTO;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [employeeNo=" + employeeNo + ", infoNo=" + infoNo + ", roomNo=" + roomNo + ", infoDTO="
				+ infoDTO + "]";
	}
	
}
