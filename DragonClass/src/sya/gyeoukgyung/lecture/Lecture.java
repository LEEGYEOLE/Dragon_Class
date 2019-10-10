package sya.gyeoukgyung.lecture;
/**
 *	Lecture�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface Lecture {
	/** ���� ��� */
	public void insertLecture();
	/** ���� ���� ����*/
	public void deleteLecture();
	/** ���������� ���� �˻� */
	public void findByDept();
	/** �̼��������� ���� �˻� */
	public void findByDivision();
	/** ���Ǹ����� ���� �˻� (���Ե� �̸� ���) */
	public void findByLecName();
	/** �����ڵ�� ���� �˻� */
	public void findByCode();
	/** ���������� ���� �˻� */
	public void findByPName();
	/** ��� ���� ��� �˻� */
	public void listLecture();
	//���� �����ȸ, �а�����, �̼��������� ��ȸ, ���������, 
	//�����ڵ��, ����������, ���ǻ���
}
