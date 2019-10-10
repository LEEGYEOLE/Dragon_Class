package sya.gyeoukgyung.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class DepartmentDAOImpl implements DepartmentDAO {
	private Connection conn = DBConn.getConnection();
	
	@Override
	public int insertDepartment(DepartmentDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("INSERT INTO department(dept_no, dept_name) VALUES(dept_seq.NEXTVAL,?)");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getDeptName());

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
	public int updateDepartment(DepartmentDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("UPDATE department SET dept_name=? WHERE dept_no=?");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, dto.getDeptName());
			pstmt.setInt(2, dto.getDeptNo());

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
	public int deleteDepartment(int deptNo) {
		PreparedStatement pstmt=null;
		int result=0;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("DELETE FROM department WHERE dept_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, deptNo);
			
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
	public List<DepartmentDTO> listDepartment() {
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("SELECT dept_no, dept_name FROM department");
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDeptNo(rs.getInt("dept_no"));
				dto.setDeptName(rs.getString("dept_name"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}
		return list;
	}
	
	
	@Override
	public List<DepartmentDTO> findByDeptName(String deptName) {
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("SELECT dept_no, dept_name FROM department WHERE INSTR(dept_name, ?)>=1");
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, deptName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDeptNo(rs.getInt("dept_no"));
				dto.setDeptName(rs.getString("dept_name"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			
		}
		return list;
		
	}
	
}
