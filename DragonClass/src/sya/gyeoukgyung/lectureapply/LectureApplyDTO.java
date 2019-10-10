package sya.gyeoukgyung.lectureapply;

/**
 * LectureApply
 */
public class LectureApplyDTO {
	private int studentNo; // 학생번호
	private int lectureNo; // 강의번호

	public LectureApplyDTO(int studentNo, int lectureNo) {
		this.studentNo = studentNo;
		this.lectureNo = lectureNo;
	}

	public LectureApplyDTO() {
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	@Override
	public String toString() {
		return "LectureApplyDTO [studentNo=" + studentNo + ", lectureNo=" + lectureNo + "]";
	}

}
