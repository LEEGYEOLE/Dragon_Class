package sya.gyeoukgyung.room;

import java.util.List;

/**
 * DB의 Room테이블과 연관된 구현체의 인터페이스
 */
public interface RoomDAO {
	/** 방 등록 */
	public int insertRoom(RoomDTO dto);
	/** 방 정보 삭제 */
	public int deleteRoom(int roomNo);
	/** 방 이름으로 방 목록 검색 */
	public List<RoomDTO> findByRoomName(String roomName);
	/** 모든 방 리스트 검색 */
	public List<RoomDTO> listRoom();

}
