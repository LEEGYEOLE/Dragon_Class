package sya.gyeoukgyung.department;
/**
 *	Department에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Department {
	/** 학과 등록 */
	public void insertDepartment();
	/** 학과 정보 수정 */
	public void updateDepartment();
	/** 학과 정보 삭제*/
	public void deleteDepartment();
	/** 모든 학과 목록 검색 */
	public void listDepartment();
	
}
