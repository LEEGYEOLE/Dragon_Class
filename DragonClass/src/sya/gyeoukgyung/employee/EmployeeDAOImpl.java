package sya.gyeoukgyung.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Connection conn = DBConn.getConnection();

	/**
	 * 교직원 정보 등록 -- 관리자
	 */
	@Override
	public int insertEmployee(EmployeeDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("INSERT ALL ");
			sb.append("INTO info(info_No, name, birth,rrn,password,entYear,dept_No ) ");
			sb.append("VALUES (INFO_SEQ.nextval,?,?,?,?,?,?) ");
			sb.append("INTO employee(emp_no, room_no, info_No) ");
			sb.append("VALUES (?,?,INFO_SEQ.currval) ");
			sb.append("select * from dual");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getInfoDTO().getName());
			pstmt.setString(2, dto.getInfoDTO().getBirth());
			pstmt.setString(3, dto.getInfoDTO().getRrn());
			pstmt.setString(4, dto.getInfoDTO().getPassword());
			pstmt.setString(5, dto.getInfoDTO().getEntYear());
			pstmt.setInt(6, dto.getInfoDTO().getDeptNo());
			pstmt.setInt(7, dto.getEmployeeNo());
			pstmt.setInt(8, dto.getRoomNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {

				} catch (Exception e2) {
				}
			}
		}
		return result;
	}

	/**
	 * 교직원 정보 등록(상세 +) -- 관리자
	 */
	@Override
	public int insertEmployeeOP(EmployeeDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("INSERT ALL ");
			sb.append("INTO info(info_No, name, birth,rrn,password,entYear,dept_No, tel, email,address ) ");
			sb.append("VALUES (INFO_SEQ.nextval,?,?,?,?,?,?,?,?,?) ");
			sb.append("INTO employee(emp_no, room_no, info_No) ");
			sb.append("VALUES (?,?,INFO_SEQ.currval) ");
			sb.append("select * from dual");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getInfoDTO().getName());
			pstmt.setString(2, dto.getInfoDTO().getBirth());
			pstmt.setString(3, dto.getInfoDTO().getRrn());
			pstmt.setString(4, dto.getInfoDTO().getPassword());
			pstmt.setString(5, dto.getInfoDTO().getEntYear());
			pstmt.setInt(6, dto.getInfoDTO().getDeptNo());
			pstmt.setString(7, dto.getInfoDTO().getTel());
			pstmt.setString(8, dto.getInfoDTO().getEmail());
			pstmt.setString(9, dto.getInfoDTO().getAddress());
			pstmt.setInt(10, dto.getEmployeeNo());
			pstmt.setInt(11, dto.getRoomNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {

				} catch (Exception e2) {
				}
			}
		}
		return result;
	}

	@Override
	public int updateEmployeePw(int infoNo, String pw) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;
		try {
			sb.append("UPDATE info SET password=? WHERE INFO_NO=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, pw);
			pstmt.setInt(2, infoNo);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			if (pstmt != null) {
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return result;
	}

	@Override
	public int deleteEmployee(int infoNo) {
		int result = 0;

		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("DELETE FROM employee WHERE info_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, infoNo);
			result = pstmt.executeUpdate();
			pstmt.close();
			sb.setLength(0);

			sb.append("DELETE FROM info WHERE info_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, infoNo);
			result += pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
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
	public List<EmployeeDTO> findByName(String name) {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select emp_no, room_no, e.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from employee e ");
			sb.append("LEFT OUTER JOIN info i on e.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE INSTR(name, ?)>0 ORDER BY e.info_no ");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeNo(rs.getInt(1));
				dto.setRoomNo(rs.getInt(2));
				dto.setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setName(rs.getString(4));
				dto.getInfoDTO().setBirth(rs.getDate(5).toString());
				dto.getInfoDTO().setRrn(rs.getString(6));
				dto.getInfoDTO().setPassword(rs.getString(7));
				dto.getInfoDTO().setTel(rs.getString(8));
				dto.getInfoDTO().setEmail(rs.getString(9));
				dto.getInfoDTO().setAddress(rs.getString(10));
				dto.getInfoDTO().setEntYear(rs.getString(11));
				dto.getInfoDTO().setDeptNo(rs.getInt(12));
				dto.getInfoDTO().setDeptName(rs.getString(13));
				list.add(dto);
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
	public List<EmployeeDTO> findByDept(int deptNo) {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select emp_no, room_no, e.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from employee e ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE d.dept_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeNo(rs.getInt(1));
				dto.setRoomNo(rs.getInt(2));
				dto.setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setName(rs.getString(4));
				dto.getInfoDTO().setBirth(rs.getDate(5).toString());
				dto.getInfoDTO().setRrn(rs.getString(6));
				dto.getInfoDTO().setPassword(rs.getString(7));
				dto.getInfoDTO().setTel(rs.getString(8));
				dto.getInfoDTO().setEmail(rs.getString(9));
				dto.getInfoDTO().setAddress(rs.getString(10));
				dto.getInfoDTO().setEntYear(rs.getString(11));
				dto.getInfoDTO().setDeptNo(rs.getInt(12));
				dto.getInfoDTO().setDeptName(rs.getString(13));
				list.add(dto);
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
	public List<EmployeeDTO> listEmployee() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select emp_no, room_no, e.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from employee e ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeNo(rs.getInt(1));
				dto.setRoomNo(rs.getInt(2));
				dto.setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setName(rs.getString(4));
				dto.getInfoDTO().setBirth(rs.getDate(5).toString());
				dto.getInfoDTO().setRrn(rs.getString(6));
				dto.getInfoDTO().setPassword(rs.getString(7));
				dto.getInfoDTO().setTel(rs.getString(8));
				dto.getInfoDTO().setEmail(rs.getString(9));
				dto.getInfoDTO().setAddress(rs.getString(10));
				dto.getInfoDTO().setEntYear(rs.getString(11));
				dto.getInfoDTO().setDeptNo(rs.getInt(12));
				dto.getInfoDTO().setDeptName(rs.getString(13));
				list.add(dto);
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
	public EmployeeDTO findByEmployeeNo(int employeeNo) {
		EmployeeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select emp_no, room_no, e.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from employee e ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE emp_no=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, employeeNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeNo(rs.getInt(1));
				dto.setRoomNo(rs.getInt(2));
				dto.setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setInfoNo(rs.getInt(3));
				dto.getInfoDTO().setName(rs.getString(4));
				dto.getInfoDTO().setBirth(rs.getDate(5).toString());
				dto.getInfoDTO().setRrn(rs.getString(6));
				dto.getInfoDTO().setPassword(rs.getString(7));
				dto.getInfoDTO().setTel(rs.getString(8));
				dto.getInfoDTO().setEmail(rs.getString(9));
				dto.getInfoDTO().setAddress(rs.getString(10));
				dto.getInfoDTO().setEntYear(rs.getString(11));
				dto.getInfoDTO().setDeptNo(rs.getInt(12));
				dto.getInfoDTO().setDeptName(rs.getString(13));
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

		return dto;

	}

	@Override
	public EmployeeDTO login(int id, String pw) {
		EmployeeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select emp_no, room_no, e.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from employee e ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE emp_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			dto = new EmployeeDTO();

			if (rs.next()) {
				dto.getInfoDTO().setPassword(rs.getString(8));
				if (!dto.getInfoDTO().getPassword().equals(pw)) {
					dto.setInfoNo(-1);
				} else {
					dto.setEmployeeNo(rs.getInt(1));
					dto.setRoomNo(rs.getInt(2));
					dto.setInfoNo(rs.getInt(3));
					dto.getInfoDTO().setInfoNo(rs.getInt(3));
					dto.getInfoDTO().setName(rs.getString(4));
					dto.getInfoDTO().setBirth(rs.getDate(5).toString());
					dto.getInfoDTO().setRrn(rs.getString(6));
					dto.getInfoDTO().setPassword(rs.getString(7));
					dto.getInfoDTO().setTel(rs.getString(8));
					dto.getInfoDTO().setEmail(rs.getString(9));
					dto.getInfoDTO().setAddress(rs.getString(10));
					dto.getInfoDTO().setEntYear(rs.getString(11));
					dto.getInfoDTO().setDeptNo(rs.getInt(12));
					dto.getInfoDTO().setDeptName(rs.getString(13));
				}
			} else {
				dto.setInfoNo(-2);
			}
		} catch (Exception e) {
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
		return dto;
	}

}
