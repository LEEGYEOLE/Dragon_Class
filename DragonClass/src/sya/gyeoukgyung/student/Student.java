package sya.gyeoukgyung.student;
/**
 *	Student에 관련된 입출력 및 DAO클래스들과의 연결을 담당하는 Service인터페이스.
 */
public interface Student {
	//관리자 기능
		/** 학생 등록 */
		public void insertStudent();
		/** 학생 비밀번호 수정 */
		public void updateStudentPw();
		/** 학생 정보 삭제*/
		public void deleteStudent();
		/** 이름으로 학생 검색 (포함된 이름 모두) */
		public void findByName();
		/** 전공명으로 학생 검색 */
		public void findByDept();
		/** 모든 학생 목록 검색 */
		public void listStudent();
		
	//학생기능
	/** 학생 정보 수정 */
	public void updateStudent(StudentDTO dto);
	/** 학생 내 비밀번호 수정 */
	public void updateStudentPw(StudentDTO dto);
	/** 학생 정보 출력 */
	public void searchStudent(StudentDTO dto);
	/** 로그인 */
	public StudentDTO login() throws NullPointerException;
}
