package sya.gyeoukgyung.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import db.DBConn;

public class LectureDAOImpl implements LectureDAO {
	private Connection conn = DBConn.getConnection();

	@Override
	public int insertLecture(LectureDTO dto) { 
			int result = 0;
			PreparedStatement pstmt = null;
			StringBuilder sb = new StringBuilder();
			System.out.println(dto.toString());
			try {
				sb.append("INSERT INTO LECTURE (LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME ");
				sb.append(", ETIME, CREDIT, COUNT, PROFESSOR_NO, SUB_NO, ROOM_NO) ");
				sb.append("VALUES(LEC_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)");
				System.out.println(sb.toString());
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, dto.getDivision());
				pstmt.setString(2, dto.getMkYear());
				pstmt.setInt(3, dto.getSemester());
				pstmt.setString(4, dto.getCDay());
				pstmt.setString(5, dto.getStartTime());
				pstmt.setString(6, dto.getEndTime());
				pstmt.setInt(7, dto.getCredit());
				pstmt.setInt(8, dto.getCount());
				pstmt.setInt(9, dto.getProfessorNo());
				pstmt.setInt(10, dto.getSubNo());
				pstmt.setInt(11, dto.getRoomNo());
				
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
	public int deleteLecture(int lecNo) {
		int result = 0;

		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("DELETE FROM LECTURE");
			sb.append(" WHERE LECTURE_NO=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, lecNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			
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
	public List<HashMap<String, Object>> findByDept(String dept) {
				
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
			sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
			sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
			sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
			sb.append("WHERE department.dept_name=?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dept);
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
				map.put("DIVISION", (rs.getString("DIVISION")));
				map.put("MKYEAR", (rs.getString("MKYEAR")));
				map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
				map.put("DAY", (rs.getString("DAY")));
				map.put("STIME", (rs.getString("STIME")));
				map.put("ETIME", (rs.getString("ETIME")));
				map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
				map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
				map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
				map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
				map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
				map.put("SUB_NAME", (rs.getString("SUB_NAME")));
				map.put("SUB_CODE", (rs.getString("SUB_CODE")));
				map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
				map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
				map.put("room_name", (rs.getString("room_name")));
				map.put("name", (rs.getString("name")));
												
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
		}

    return list;

	
	}
	
		
		public List<HashMap<String, Object>> findByLecName(String lecName) {
			
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
			sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
			sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
			sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
			sb.append("WHERE subject.sub_name=?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, lecName);
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
				map.put("DIVISION", (rs.getString("DIVISION")));
				map.put("MKYEAR", (rs.getString("MKYEAR")));
				map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
				map.put("DAY", (rs.getString("DAY")));
				map.put("STIME", (rs.getString("STIME")));
				map.put("ETIME", (rs.getString("ETIME")));
				map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
				map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
				map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
				map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
				map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
				map.put("SUB_NAME", (rs.getString("SUB_NAME")));
				map.put("SUB_CODE", (rs.getString("SUB_CODE")));
				map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
				map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
				map.put("room_name", (rs.getString("room_name")));
				map.put("name", (rs.getString("name")));
				
								
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
		}

    return list;

	
	}

	
		@Override
		public List<HashMap<String, Object>> findByCode(String code) {
							
			List<HashMap<String, Object>> list = new ArrayList<>();
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuilder sb = new StringBuilder();

			try {
				sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
				sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
				sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
				sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
				sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
				sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
				sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
				sb.append("WHERE subject.sub_code=?");
				
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, code);
							
				rs = pstmt.executeQuery();

				while (rs.next()) {
					map = new HashMap<String, Object>();
					map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
					map.put("DIVISION", (rs.getString("DIVISION")));
					map.put("MKYEAR", (rs.getString("MKYEAR")));
					map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
					map.put("DAY", (rs.getString("DAY")));
					map.put("STIME", (rs.getString("STIME")));
					map.put("ETIME", (rs.getString("ETIME")));
					map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
					map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
					map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
					map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
					map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
					map.put("SUB_NAME", (rs.getString("SUB_NAME")));
					map.put("SUB_CODE", (rs.getString("SUB_CODE")));
					map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
					map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
					map.put("room_name", (rs.getString("room_name")));
					map.put("name", (rs.getString("name")));
					
									
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
			}

	    return list;

		
		}

	
	
	@Override
	public List<HashMap<String, Object>> listLecture() {
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
			sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
			sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
			sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
			
			pstmt = conn.prepareStatement(sb.toString());
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
				map.put("DIVISION", (rs.getString("DIVISION")));
				map.put("MKYEAR", (rs.getString("MKYEAR")));
				map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
				map.put("DAY", (rs.getString("DAY")));
				map.put("STIME", (rs.getString("STIME")));
				map.put("ETIME", (rs.getString("ETIME")));
				map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
				map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
				map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
				map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
				map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
				map.put("SUB_NAME", (rs.getString("SUB_NAME")));
				map.put("SUB_CODE", (rs.getString("SUB_CODE")));
				map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
				map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
				map.put("room_name", (rs.getString("room_name")));
				map.put("name", (rs.getString("name")));
				
								
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
		}

    return list;

	
	}


	@Override
	public List<HashMap<String, Object>> findByDivision(String div) {
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
			sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
			sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
			sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
			sb.append("WHERE lecture.division=?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, div);
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
				map.put("DIVISION", (rs.getString("DIVISION")));
				map.put("MKYEAR", (rs.getString("MKYEAR")));
				map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
				map.put("DAY", (rs.getString("DAY")));
				map.put("STIME", (rs.getString("STIME")));
				map.put("ETIME", (rs.getString("ETIME")));
				map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
				map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
				map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
				map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
				map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
				map.put("SUB_NAME", (rs.getString("SUB_NAME")));
				map.put("SUB_CODE", (rs.getString("SUB_CODE")));
				map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
				map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
				map.put("room_name", (rs.getString("room_name")));
				map.put("name", (rs.getString("name")));
				
								
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
		}

    return list;

	
	}


	@Override
	public List<HashMap<String, Object>> findByPname(String pname) {
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("SELECT LECTURE_NO, DIVISION, MKYEAR, SEMESTER, DAY, STIME, ");
			sb.append("ETIME, CREDIT, COUNT, LECTURE.PROFESSOR_NO, lecture.SUB_NO, ROOM.ROOM_NO, SUB_NAME, SUB_CODE,");
			sb.append("DEPARTMENT.DEPT_NO, DEPT_NAME, room_name, name FROM LECTURE ");
			sb.append("left outer join subject on lecture.sub_no = subject.sub_no ");
			sb.append("left outer join DEPARTMENT on SUBJECT.dept_no = DEPARTMENT.dept_no ");
			sb.append("left outer join ROOM on ROOM.ROOM_NO = LECTURE.ROOM_NO ");
			sb.append("left outer join INFO on INFO.INFO_NO = LECTURE.PROFESSOR_NO ");
			sb.append("WHERE info.name=?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, pname);
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("LECTURE_NO", String.valueOf(rs.getInt("LECTURE_NO")));
				map.put("DIVISION", (rs.getString("DIVISION")));
				map.put("MKYEAR", (rs.getString("MKYEAR")));
				map.put("SEMESTER", String.valueOf(rs.getInt("SEMESTER")));
				map.put("DAY", (rs.getString("DAY")));
				map.put("STIME", (rs.getString("STIME")));
				map.put("ETIME", (rs.getString("ETIME")));
				map.put("CREDIT", String.valueOf(rs.getInt("CREDIT")));
				map.put("COUNT", String.valueOf(rs.getInt("COUNT")));
				map.put("PROFESSOR_NO", String.valueOf(rs.getInt("PROFESSOR_NO")));
				map.put("SUB_NO", String.valueOf(rs.getInt("SUB_NO")));
				map.put("ROOM_NO", String.valueOf(rs.getInt("ROOM_NO")));
				map.put("SUB_NAME", (rs.getString("SUB_NAME")));
				map.put("SUB_CODE", (rs.getString("SUB_CODE")));
				map.put("DEPT_NO", String.valueOf(rs.getInt("DEPT_NO")));
				map.put("DEPT_NAME", (rs.getString("DEPT_NAME")));
				map.put("room_name", (rs.getString("room_name")));
				map.put("name", (rs.getString("name")));
				
								
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
		}

    return list;
	
		
   }
}

	

