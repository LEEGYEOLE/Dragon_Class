package sya.gyeoukgyung.student;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * DB의 Student테이블과 연관된 구현체의 인터페이스
 */
public interface StudentDAO {
	/** 학생 등록 */
	public int insertStudent(StudentDTO dto) throws SQLIntegrityConstraintViolationException;
	/** 학생 등록 (상세정보까지 )*/
	public int insertStudentOP(StudentDTO dto);
	/** 학생 비밀번호 수정 */
	public int updateStudentPw(int infoNo, String pw);
	/** 학생 정보 삭제*/
	public int deleteStudent(int studentNo);
	/** 학번으로 학생 검색*/
	public StudentDTO findByStudentNo(int studentNo)  throws SQLIntegrityConstraintViolationException;
	/** 이름으로 학생 검색 (포함된 이름 모두) */
	public List<StudentDTO> findByName(String name);
	/** 전공명으로 학생 검색 */
	public List<StudentDTO> findByDept(int deptNo);
	/** 모든 학생 리스트 검색 */
	public List<StudentDTO> listStudent();
	
	/** 로그인 */
	public StudentDTO login(int id, String pw);
	/** 학생 정보 수정 */
	public int updateStudent(StudentDTO dto);
	public StudentDTO findByInfoNo(int infoNo);
}
