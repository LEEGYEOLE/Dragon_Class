package sya.gyeoukgyung.lecture;
/**
 *	Lecture에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Lecture {
	/** 강의 등록 */
	public void insertLecture();
	/** 강의 정보 삭제*/
	public void deleteLecture();
	/** 전공명으로 강의 검색 */
	public void findByDept();
	/** 이수구분으로 강의 검색 */
	public void findByDivision();
	/** 강의명으로 강의 검색 (포함된 이름 모두) */
	public void findByLecName();
	/** 과목코드로 강의 검색 */
	public void findByCode();
	/** 교수명으로 강의 검색 */
	public void findByPName();
	/** 모든 강의 목록 검색 */
	public void listLecture();
	//강좌 모두조회, 학과별로, 이수구분으로 조회, 과목명으로, 
	//과목코드로, 교수명으로, 강의삭제
}
