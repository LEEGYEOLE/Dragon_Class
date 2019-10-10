package sya.gyeoukgyung.subject;
/**
 *	Subject�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface Subject {
	/** ���� ��� */
	public void insertSubject();
	/** ���� ���� ����*/
	public void deleteSubject();
	/** ��������� ���� �˻� (���Ե� �̸� ���) */
	public void findBySubName();
	/** �����ȣ�� ���� �˻�  */
	public void findBySubNo();
	/** �����ڵ�� ���� �˻� (���Ե� �����ڵ� ���) */
	public void findBySubCode();
	/** ������ȣ�� ���� �˻� */
	public void findByDept();
	/** ��� ���� ��� �˻� */
	public void listSubject();
	
}
