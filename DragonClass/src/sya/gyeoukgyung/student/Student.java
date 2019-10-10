package sya.gyeoukgyung.student;
/**
 *	Student�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface Student {
	//������ ���
		/** �л� ��� */
		public void insertStudent();
		/** �л� ��й�ȣ ���� */
		public void updateStudentPw();
		/** �л� ���� ����*/
		public void deleteStudent();
		/** �̸����� �л� �˻� (���Ե� �̸� ���) */
		public void findByName();
		/** ���������� �л� �˻� */
		public void findByDept();
		/** ��� �л� ��� �˻� */
		public void listStudent();
		
	//�л����
	/** �л� ���� ���� */
	public void updateStudent(StudentDTO dto);
	/** �л� �� ��й�ȣ ���� */
	public void updateStudentPw(StudentDTO dto);
	/** �л� ���� ��� */
	public void searchStudent(StudentDTO dto);
	/** �α��� */
	public StudentDTO login() throws NullPointerException;
}
