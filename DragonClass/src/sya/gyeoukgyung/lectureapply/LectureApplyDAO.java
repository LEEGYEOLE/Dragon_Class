package sya.gyeoukgyung.lectureapply;

import java.util.List;
import java.util.Map;

/**
 * DB의 LectureApply테이블과 연관된 구현체의 인터페이스
 */
public interface LectureApplyDAO {
	/** 수강신청 등록 */
	public int insertLectureApply(LectureApplyDTO dto);
	/** 수강신청 정보 삭제 */
	public int deleteLectureApply(LectureApplyDTO dto);
	/** 모든 수강신청 목록 검색 */
	public List<Map<String, Object>> listLectureApply(int infoNo);

}
