package sya.gyeoukgyung.lectureapply;
/**
 *	LectureApply에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface LectureApply {
	/** 수강신청 등록 */
	public void insertLectureApply(int infoNo);
	/** 수강신청 정보 삭제*/
	public void deleteLectureApply(int infoNo);
	/** 모든 수강신청 목록 검색 */
	public void listLectureApplyByinfoNo(int infoNo);
	
}
