package sya.gyeoukgyung.room;
/**
 * ������
 */
public class RoomDTO {
	private int roomNo;	//���ȣ
	private String roomName;	//���̸�
	private String buildingName;	//�ǹ��̸�
	
	
	public RoomDTO() {
	}
	public RoomDTO(int roomNo, String roomName, String buildingName) {
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.buildingName = buildingName;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	@Override
	public String toString() {
		return "RoomDTO [roomNo=" + roomNo + ", roomName=" + roomName + ", buildingName=" + buildingName + "]";
	}
	
}
