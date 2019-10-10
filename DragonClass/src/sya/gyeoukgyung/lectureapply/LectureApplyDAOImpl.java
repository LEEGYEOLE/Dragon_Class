package sya.gyeoukgyung.lectureapply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBConn;

public class LectureApplyDAOImpl implements LectureApplyDAO{

	private Connection conn = DBConn.getConnection();
	@Override
	public int insertLectureApply(LectureApplyDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLectureApply(LectureApplyDTO dto) {
		int result = 0;

		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("DELETE FROM Lecture_Apply WHERE info_no=? and LECTURE_NO=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getStudentNo());
			pstmt.setInt(2, dto.getLectureNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> listLectureApply(int infoNo) {
		
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select lecture.LECTURE_NO, sub_name, dept_name, DIVISION, name, DAY, ");
			sb.append("STIME,ETIME, room_name,CREDIT ");
			sb.append("from LECTURE_APPLY ");
			sb.append("left outer join lecture on lecture.LECTURE_NO = LECTURE_APPLY.LECTURE_NO ");
			sb.append("left outer join info on lecture.PROFESSOR_NO = info.info_no ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on subject.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join room on lecture.room_no = room.room_no ");
			sb.append("WHERE LECTURE_APPLY.info_no=?");
			
			pstmt = conn.prepareStatement(sb.toString());
						pstmt.setInt(1, infoNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<>();
				map.put("LECTURE_NO", rs.getString("LECTURE_NO"));
				map.put("sub_name", rs.getString("sub_name"));
				map.put("dept_name", rs.getString("dept_name"));
				map.put("DIVISION", rs.getString("DIVISION"));
				map.put("name", rs.getString("name"));
				map.put("DAY", rs.getString("DAY"));
				map.put("STIME", rs.getString("STIME"));
				map.put("ETIME", rs.getString("ETIME"));
				map.put("room_name", rs.getString("room_name"));
				map.put("CREDIT", rs.getInt("CREDIT"));
				
				list.add(map);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(list.size()==0)
				throw new NullPointerException();
		}

		return list;
	}

}
