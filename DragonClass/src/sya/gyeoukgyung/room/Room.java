package sya.gyeoukgyung.room;
/**
 *	Room�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface Room {
	/** �� ��� */
	public void insertRoom();
	/** �� ���� ����*/
	public void deleteRoom();
	/** �� �̸����� �� ��� �˻� */
	public void findByRoomName();
	/** ��� �� ��� �˻� */
	public void listRoom();
}
