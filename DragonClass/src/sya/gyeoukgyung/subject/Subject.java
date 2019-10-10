package sya.gyeoukgyung.subject;
/**
 *	Subject에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Subject {
	/** 과목 등록 */
	public void insertSubject();
	/** 과목 정보 삭제*/
	public void deleteSubject();
	/** 과목명으로 과목 검색 (포함된 이름 모두) */
	public void findBySubName();
	/** 과목번호로 과목 검색  */
	public void findBySubNo();
	/** 과목코드로 과목 검색 (포함된 과목코드 모두) */
	public void findBySubCode();
	/** 전공번호로 과목 검색 */
	public void findByDept();
	/** 모든 과목 목록 검색 */
	public void listSubject();
	
}
