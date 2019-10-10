package sya.gyeoukgyung.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class RoomDAOImpl implements RoomDAO{
	private Connection conn = DBConn.getConnection();
	@Override
	public int insertRoom(RoomDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("INSERT INTO room(room_no, room_name, building_name) ");
			sb.append("VALUES(room_seq.NEXTVAL, ?, ?) ");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getRoomName());
			pstmt.setString(2, dto.getBuildingName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		return result;
	}

	@Override
	public int deleteRoom(int roomNo) {
		PreparedStatement pstmt=null;
		int result=0;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("DELETE FROM room WHERE room_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, roomNo);
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		
		return result;
	}

	@Override
	public List<RoomDTO> listRoom() {
		List<RoomDTO> list=new ArrayList<RoomDTO>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT room_no, room_name, building_name FROM room");
			pstmt=conn.prepareStatement(sb.toString());
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO dto=new RoomDTO();
				dto.setRoomNo(rs.getInt("room_no"));
				dto.setRoomName(rs.getString("room_name"));
				dto.setBuildingName(rs.getString("building_name"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e2) {
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		
		return list;
	}


	@Override
	public List<RoomDTO> findByRoomName(String roomName) {
		List<RoomDTO> list=new ArrayList<RoomDTO>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT room_no, room_name, building_name FROM room WHERE INSTR(room_name, ?)>=1");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, roomName);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO dto=new RoomDTO();
				dto.setRoomNo(rs.getInt("room_no"));
				dto.setRoomName(rs.getString("room_name"));
				dto.setBuildingName(rs.getString("building_name"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e2) {
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		
		return list;
	}

}
