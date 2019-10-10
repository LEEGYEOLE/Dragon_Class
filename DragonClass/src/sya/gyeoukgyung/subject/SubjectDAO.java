package sya.gyeoukgyung.subject;

import java.util.HashMap;
import java.util.List;

public interface SubjectDAO {
	/** 과목 등록 */
	public int insertSubject(SubjectDTO dto);
	/** 과목 정보 삭제*/
	public int deleteSubject(int subNo);
	/** 과목명으로 과목 검색 (포함된 이름 모두) */
	public List<HashMap<String, Object>> findBySubName(String name);
	/** 과목번호로 과목 검색 */
	public List<HashMap<String, Object>> findBySubNo(int subNo);
	/** 과목코드로 과목 검색 (포함된 과목코드 모두) */
	public List<HashMap<String, Object>> findBySubCode(String subCode);
	/** 전공번호로 과목 검색 */
	public List<HashMap<String, Object>> findByDept(int deptNo);
	/** 모든 과목 목록 검색 */
	public List<HashMap<String, Object>> listSubject();

}
