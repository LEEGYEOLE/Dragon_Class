package sya.gyeoukgyung.room;

import java.util.List;

/**
 * DB�� Room���̺�� ������ ����ü�� �������̽�
 */
public interface RoomDAO {
	/** �� ��� */
	public int insertRoom(RoomDTO dto);
	/** �� ���� ���� */
	public int deleteRoom(int roomNo);
	/** �� �̸����� �� ��� �˻� */
	public List<RoomDTO> findByRoomName(String roomName);
	/** ��� �� ����Ʈ �˻� */
	public List<RoomDTO> listRoom();

}
