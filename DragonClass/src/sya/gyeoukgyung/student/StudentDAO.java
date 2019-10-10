package sya.gyeoukgyung.student;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * DB�� Student���̺�� ������ ����ü�� �������̽�
 */
public interface StudentDAO {
	/** �л� ��� */
	public int insertStudent(StudentDTO dto) throws SQLIntegrityConstraintViolationException;
	/** �л� ��� (���������� )*/
	public int insertStudentOP(StudentDTO dto);
	/** �л� ��й�ȣ ���� */
	public int updateStudentPw(int infoNo, String pw);
	/** �л� ���� ����*/
	public int deleteStudent(int studentNo);
	/** �й����� �л� �˻�*/
	public StudentDTO findByStudentNo(int studentNo)  throws SQLIntegrityConstraintViolationException;
	/** �̸����� �л� �˻� (���Ե� �̸� ���) */
	public List<StudentDTO> findByName(String name);
	/** ���������� �л� �˻� */
	public List<StudentDTO> findByDept(int deptNo);
	/** ��� �л� ����Ʈ �˻� */
	public List<StudentDTO> listStudent();
	
	/** �α��� */
	public StudentDTO login(int id, String pw);
	/** �л� ���� ���� */
	public int updateStudent(StudentDTO dto);
	public StudentDTO findByInfoNo(int infoNo);
}
