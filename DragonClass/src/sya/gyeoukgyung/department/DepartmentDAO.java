package sya.gyeoukgyung.department;

import java.util.List;

/**
 * DB의 Department테이블과 연관된 구현체의 인터페이스
 */
public interface DepartmentDAO {
	/** 학과 등록 */
	public int insertDepartment(DepartmentDTO dto);
	/** 학과 정보 수정 */
	public int updateDepartment(DepartmentDTO dto);
	/** 학과 정보 삭제 */
	public int deleteDepartment(int deptNo);
	/** 학과명으로 학과검색  */
	public List<DepartmentDTO> findByDeptName(String deptName);
	/** 모든 학과 리스트 검색 */
	public List<DepartmentDTO> listDepartment();
}
