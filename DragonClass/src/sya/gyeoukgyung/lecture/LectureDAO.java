package sya.gyeoukgyung.lecture;

import java.util.HashMap;
import java.util.List;
/**
 *	Lecture에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface LectureDAO {
	/** 강의 등록 */
	public int insertLecture(LectureDTO dto);
	/** 강의 정보 삭제*/
	public int deleteLecture(int lecNo);
	/** 학과명으로 강의 검색 */
	public List<HashMap<String, Object>> findByDept(String dept);
	/** 이수구분으로 강의 검색 */
	public List<HashMap<String, Object>> findByDivision(String div);
	/** 과목명으로 강의 검색 (포함된 이름 모두) */
	public List<HashMap<String, Object>> findByLecName(String lecName);
	/** 과목코드로 강의 검색 */
	public List<HashMap<String, Object>> findByCode(String code);
	/** 교수명으로 강의 검색 */
	public List<HashMap<String, Object>> findByPname(String pname);
	/** 모든 강의 목록 검색 */
	public List<HashMap<String, Object>> listLecture();
	//강좌 모두조회, 학과별로, 이수구분으로 조회, 과목명으로, 
	//과목코드로, 교수명으로, 강의삭제
}
