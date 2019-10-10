package sya.gyeoukgyung.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import db.DBConn;

public class SubjectDAOImpl implements SubjectDAO {
	private Connection conn=DBConn.getConnection();
	
	@Override
	public int insertSubject(SubjectDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("INSERT INTO subject(sub_no, sub_name, sub_code, dept_no)");
			sb.append(" VALUES(sub_seq.NEXTVAL, ?, ?, ?)");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, dto.getSubName());
			pstmt.setString(2, dto.getSubCode());
			pstmt.setInt(3, dto.getDeptNo());
			
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
	public int deleteSubject(int subNo) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("DELETE FROM subject WHERE sub_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, subNo);
			
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
	public List<HashMap<String, Object>> findBySubName(String name) {
		HashMap<String, Object> map=null;
		List<HashMap<String, Object>> list= new ArrayList<HashMap<String,Object>>();
		
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT s.dept_no, dept_name, sub_no, sub_name, sub_code");
			sb.append(" FROM subject s LEFT OUTER JOIN department d");
			sb.append(" ON s.dept_no=d.dept_no WHERE INSTR(sub_name, ?)>=1");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				map=new HashMap<String, Object>();
				map.put("dept_no", rs.getInt("dept_no"));
				map.put("dept_name", rs.getString("dept_name"));
				map.put("sub_no", rs.getInt("sub_no"));
				map.put("sub_name", rs.getString("sub_name"));
				map.put("sub_code", rs.getString("sub_code"));
				
				list.add(map);
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
	public List<HashMap<String, Object>> findBySubCode(String subCode) {
		HashMap<String, Object> map=null;
		List<HashMap<String, Object>> list= new ArrayList<HashMap<String,Object>>();
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT s.dept_no, dept_name, sub_no, sub_name, sub_code");
			sb.append(" FROM subject s LEFT OUTER JOIN department d");
			sb.append(" ON s.dept_no=d.dept_no WHERE INSTR(sub_code, ?)>=1");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, subCode);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				map=new HashMap<String, Object>();
				map.put("dept_no", rs.getInt("dept_no"));
				map.put("dept_name", rs.getString("dept_name"));
				map.put("sub_no", rs.getInt("sub_no"));
				map.put("sub_name", rs.getString("sub_name"));
				map.put("sub_code", rs.getString("sub_code"));
				
				list.add(map);
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
	public List<HashMap<String, Object>> findByDept(int deptNo) {
		HashMap<String, Object> map=null;
		List<HashMap<String, Object>> list= new ArrayList<HashMap<String,Object>>();
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT s.dept_no, dept_name, sub_no, sub_name, sub_code");
			sb.append(" FROM subject s LEFT OUTER JOIN department d");
			sb.append(" ON s.dept_no=d.dept_no WHERE s.dept_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, deptNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				map=new HashMap<String, Object>();
				map.put("dept_no", rs.getInt("dept_no"));
				map.put("dept_name", rs.getString("dept_name"));
				map.put("sub_no", rs.getInt("sub_no"));
				map.put("sub_name", rs.getString("sub_name"));
				map.put("sub_code", rs.getString("sub_code"));
				
				list.add(map);
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
	public List<HashMap<String, Object>> listSubject() {
		HashMap<String, Object> map=null;
		List<HashMap<String, Object>> list= new ArrayList<HashMap<String,Object>>();
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT s.dept_no, dept_name, sub_no, sub_name, sub_code");
			sb.append(" FROM subject s LEFT OUTER JOIN department d");
			sb.append(" ON s.dept_no=d.dept_no ORDER BY s.dept_no, sub_no");
			pstmt=conn.prepareStatement(sb.toString());
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				map=new HashMap<String, Object>();
				map.put("dept_no", rs.getInt("dept_no"));
				map.put("dept_name", rs.getString("dept_name"));
				map.put("sub_no", rs.getInt("sub_no"));
				map.put("sub_name", rs.getString("sub_name"));
				map.put("sub_code", rs.getString("sub_code"));
				
				list.add(map);
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
	public List<HashMap<String, Object>> findBySubNo(int subNo) {
			HashMap<String, Object> map=null;
			List<HashMap<String, Object>> list= new ArrayList<HashMap<String,Object>>();
			
			ResultSet rs=null;
			PreparedStatement pstmt=null;
			StringBuffer sb=new StringBuffer();
			
			try {
				sb.append("SELECT s.dept_no, dept_name, sub_no, sub_name, sub_code");
				sb.append(" FROM subject s LEFT OUTER JOIN department d");
				sb.append(" ON s.dept_no=d.dept_no WHERE sub_no=?");
				pstmt=conn.prepareStatement(sb.toString());
				
				pstmt.setInt(1, subNo);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					map=new HashMap<String, Object>();
					map.put("dept_no", rs.getInt("dept_no"));
					map.put("dept_name", rs.getString("dept_name"));
					map.put("sub_no", rs.getInt("sub_no"));
					map.put("sub_name", rs.getString("sub_name"));
					map.put("sub_code", rs.getString("sub_code"));
					
					list.add(map);
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
