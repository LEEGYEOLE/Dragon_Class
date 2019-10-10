package sya.gyeoukgyung.employee;
/**
 *	Employee에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Employee {
	/** 교직원 등록 */
	public void insertEmployee();
	/** 교직원 정보 수정 */
	public void updateEmployee();
	/** 교직원 비밀번호 수정 */
	public void updateEmployeePw();
	/** 교직원 정보 삭제*/
	public void deleteEmployee();
	/** 교번으로 교직원 검색*/
	public void findByEmployeeNo();
	/** 이름으로 교직원 검색 (포함된 이름 모두) */
	public void findByName();
	/** 전공명으로 교직원 검색 */
	public void findByDept();
	/** 모든 교직원 목록 검색 */
	public void listEmployee();
	/** 로그인 */
	public EmployeeDTO login();
}
