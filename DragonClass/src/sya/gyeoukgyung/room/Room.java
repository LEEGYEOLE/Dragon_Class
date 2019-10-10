package sya.gyeoukgyung.room;
/**
 *	Room에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Room {
	/** 방 등록 */
	public void insertRoom();
	/** 방 정보 삭제*/
	public void deleteRoom();
	/** 방 이름으로 방 목록 검색 */
	public void findByRoomName();
	/** 모든 방 목록 검색 */
	public void listRoom();
}
