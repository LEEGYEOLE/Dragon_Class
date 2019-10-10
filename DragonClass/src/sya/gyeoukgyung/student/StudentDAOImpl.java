package sya.gyeoukgyung.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class StudentDAOImpl implements StudentDAO {
	private Connection conn = DBConn.getConnection();

	/**
	 * 학생 정보 등록 -- 관리자
	 */
	@Override
	public int insertStudent(StudentDTO dto) throws SQLIntegrityConstraintViolationException{
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append(
					"INSERT ALL INTO info(info_No, name, birth,rrn,password,entYear,dept_No ) VALUES (INFO_SEQ.nextval,?,?,?,?,?,?) ");
			sb.append("INTO student(student_No, haknyun, status, info_No) VALUES (?,?,?,INFO_SEQ.currval) ");
			sb.append("select * from dual");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getInfoDTO().getName());
			pstmt.setString(2, dto.getInfoDTO().getBirth());
			pstmt.setString(3, dto.getInfoDTO().getRrn());
			pstmt.setString(4, dto.getInfoDTO().getPassword());
			pstmt.setString(5, dto.getInfoDTO().getEntYear());
			pstmt.setInt(6, dto.getInfoDTO().getDeptNo());
			pstmt.setInt(7, dto.getStudentNo());
			pstmt.setInt(8, dto.getHaknyun());
			pstmt.setString(9, dto.getStatus());
			result = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new SQLIntegrityConstraintViolationException();
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
	 * 학생 정보 등록 (상세정보) -- 관리자
	 */
	@Override
	public int insertStudentOP(StudentDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append(
					"INSERT ALL INTO info(info_No, name, birth,rrn,password,entYear,dept_No,tel, email,address  ) VALUES (INFO_SEQ.nextval,?,?,?,?,?,?,?,?,?) ");
			sb.append("INTO student(student_No, haknyun, status, info_No) VALUES (?,?,?,INFO_SEQ.currval) ");
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
			pstmt.setInt(10, dto.getStudentNo());
			pstmt.setInt(11, dto.getHaknyun());
			pstmt.setString(12, dto.getStatus());
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
	 * 사용자 비밀번호 변경 -관리자, 회원
	 */
	@Override
	public int updateStudentPw(int infoNo, String pw) {
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

	/**
	 * 사용자 상세정보 수정(핸드폰, 이메일, 주소) - 학생
	 */
	@Override
	public int updateStudent(StudentDTO dto) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstmt = null;

		try {
			sb.append("UPDATE info SET TEL=?, EMAIL=?, ADDRESS=? WHERE INFO_NO=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getInfoDTO().getTel());
			pstmt.setString(2, dto.getInfoDTO().getEmail());
			pstmt.setString(3, dto.getInfoDTO().getAddress());
			pstmt.setInt(4, dto.getInfoNo());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
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
	public int deleteStudent(int infoNo) {
		int result = 0;

		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("DELETE FROM lecture_apply WHERE info_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, infoNo);
			result = pstmt.executeUpdate();
			pstmt.close();
			sb.setLength(0);
			
			sb.append("DELETE FROM student WHERE info_no=?");
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
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public StudentDTO findByStudentNo(int studentNo) throws SQLIntegrityConstraintViolationException {
		StudentDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE student_no=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, studentNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStudentNo(rs.getInt(1));
				dto.setHaknyun(rs.getInt(2));
				dto.setStatus(rs.getString(3));
				dto.setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setName(rs.getString(5));
				dto.getInfoDTO().setBirth(rs.getDate(6).toString());
				dto.getInfoDTO().setRrn(rs.getString(7));
				dto.getInfoDTO().setPassword(rs.getString(8));
				dto.getInfoDTO().setTel(rs.getString(9));
				dto.getInfoDTO().setEmail(rs.getString(10));
				dto.getInfoDTO().setAddress(rs.getString(11));
				dto.getInfoDTO().setEntYear(rs.getString(12));
				dto.getInfoDTO().setDeptNo(rs.getInt(13));
				dto.getInfoDTO().setDeptName(rs.getString(14));
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복중복");
			throw new SQLIntegrityConstraintViolationException();
		} catch (Exception e) {
e.printStackTrace();		} finally {
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
	public StudentDTO findByInfoNo(int infoNo) {
		StudentDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE i.info_no=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, infoNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStudentNo(rs.getInt(1));
				dto.setHaknyun(rs.getInt(2));
				dto.setStatus(rs.getString(3));
				dto.setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setName(rs.getString(5));
				dto.getInfoDTO().setBirth(rs.getDate(6).toString());
				dto.getInfoDTO().setRrn(rs.getString(7));
				dto.getInfoDTO().setPassword(rs.getString(8));
				dto.getInfoDTO().setTel(rs.getString(9));
				dto.getInfoDTO().setEmail(rs.getString(10));
				dto.getInfoDTO().setAddress(rs.getString(11));
				dto.getInfoDTO().setEntYear(rs.getString(12));
				dto.getInfoDTO().setDeptNo(rs.getInt(13));
				dto.getInfoDTO().setDeptName(rs.getString(14));
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
	public List<StudentDTO> findByName(String name) {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE INSTR(name, ?)>0 ORDER BY s.info_no ");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentNo(rs.getInt(1));
				dto.setHaknyun(rs.getInt(2));
				dto.setStatus(rs.getString(3));
				dto.setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setName(rs.getString(5));
				dto.getInfoDTO().setBirth(rs.getDate(6).toString());
				dto.getInfoDTO().setRrn(rs.getString(7));
				dto.getInfoDTO().setPassword(rs.getString(8));
				dto.getInfoDTO().setTel(rs.getString(9));
				dto.getInfoDTO().setEmail(rs.getString(10));
				dto.getInfoDTO().setAddress(rs.getString(11));
				dto.getInfoDTO().setEntYear(rs.getString(12));
				dto.getInfoDTO().setDeptNo(rs.getInt(13));
				dto.getInfoDTO().setDeptName(rs.getString(14));
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
	public List<StudentDTO> findByDept(int deptNo) {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE i.dept_no=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, deptNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentNo(rs.getInt(1));
				dto.setHaknyun(rs.getInt(2));
				dto.setStatus(rs.getString(3));
				dto.setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setName(rs.getString(5));
				dto.getInfoDTO().setBirth(rs.getDate(6).toString());
				dto.getInfoDTO().setRrn(rs.getString(7));
				dto.getInfoDTO().setPassword(rs.getString(8));
				dto.getInfoDTO().setTel(rs.getString(9));
				dto.getInfoDTO().setEmail(rs.getString(10));
				dto.getInfoDTO().setAddress(rs.getString(11));
				dto.getInfoDTO().setEntYear(rs.getString(12));
				dto.getInfoDTO().setDeptNo(rs.getInt(13));
				dto.getInfoDTO().setDeptName(rs.getString(14));
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
	public List<StudentDTO> listStudent() {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentNo(rs.getInt(1));
				dto.setHaknyun(rs.getInt(2));
				dto.setStatus(rs.getString(3));
				dto.setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setInfoNo(rs.getInt(4));
				dto.getInfoDTO().setName(rs.getString(5));
				dto.getInfoDTO().setBirth(rs.getDate(6).toString());
				dto.getInfoDTO().setRrn(rs.getString(7));
				dto.getInfoDTO().setPassword(rs.getString(8));
				dto.getInfoDTO().setTel(rs.getString(9));
				dto.getInfoDTO().setEmail(rs.getString(10));
				dto.getInfoDTO().setAddress(rs.getString(11));
				dto.getInfoDTO().setEntYear(rs.getString(12));
				dto.getInfoDTO().setDeptNo(rs.getInt(13));
				dto.getInfoDTO().setDeptName(rs.getString(14));
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
	public StudentDTO login(int id, String pwd) {
		StudentDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append("select student_no, haknyun, status, s.info_no, name,birth,rrn ");
			sb.append(", password, tel,email,address,entyear,i.dept_no, dept_name ");
			sb.append("from student s ");
			sb.append("LEFT OUTER JOIN info i on s.info_no=i.info_no ");
			sb.append("LEFT OUTER JOIN department d on d.dept_no=i.dept_no ");
			sb.append("WHERE student_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			dto = new StudentDTO();

			if (rs.next()) {
				dto.getInfoDTO().setPassword(rs.getString(8));
				if (!dto.getInfoDTO().getPassword().equals(pwd)) {
					dto.setInfoNo(-1);
				} else {
					dto.setStudentNo(rs.getInt(1));
					dto.setHaknyun(rs.getInt(2));
					dto.setStatus(rs.getString(3));
					dto.setInfoNo(rs.getInt(4));
					dto.getInfoDTO().setInfoNo(rs.getInt(4));
					dto.getInfoDTO().setName(rs.getString(5));
					dto.getInfoDTO().setBirth(rs.getDate(6).toString());
					dto.getInfoDTO().setRrn(rs.getString(7));
					dto.getInfoDTO().setTel(rs.getString(9));
					dto.getInfoDTO().setEmail(rs.getString(10));
					dto.getInfoDTO().setAddress(rs.getString(11));
					dto.getInfoDTO().setEntYear(rs.getString(12));
					dto.getInfoDTO().setDeptNo(rs.getInt(13));
					dto.getInfoDTO().setDeptName(rs.getString(14));
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
