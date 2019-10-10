package sya.gyeoukgyung.employee;

import java.util.List;

import sya.gyeoukgyung.student.StudentDTO;

/**
 * DB의 Employee테이블과 연관된 구현체의 인터페이스
 */
public interface EmployeeDAO {
	/** 교직원 등록 */
	public int insertEmployee(EmployeeDTO dto);
	/** 교직원 등록(+상세)*/
	public int insertEmployeeOP(EmployeeDTO dto);
	/** 교직원 비밀번호 수정 */
	public int updateEmployeePw(int infoNo, String pw);
	/** 교직원 정보 삭제*/
	public int deleteEmployee(int employeeNo);
	/** 이름으로 교직원 검색 (포함된 이름 모두) */
	public List<EmployeeDTO> findByName(String name);	
	/** 학번으로 교직원 검색*/
	public EmployeeDTO findByEmployeeNo(int employeeNo);
	/** 전공명으로 교직원 검색 */
	public List<EmployeeDTO> findByDept(int deptNo);
	/** 모든 교직원 리스트 검색 */
	public List<EmployeeDTO> listEmployee();
	/** 로그인 */
	public EmployeeDTO login(int id, String pw);
	

}
