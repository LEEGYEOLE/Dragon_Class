package sya.gyeoukgyung.employee;
/**
 *	Employee�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface Employee {
	/** ������ ��� */
	public void insertEmployee();
	/** ������ ���� ���� */
	public void updateEmployee();
	/** ������ ��й�ȣ ���� */
	public void updateEmployeePw();
	/** ������ ���� ����*/
	public void deleteEmployee();
	/** �������� ������ �˻�*/
	public void findByEmployeeNo();
	/** �̸����� ������ �˻� (���Ե� �̸� ���) */
	public void findByName();
	/** ���������� ������ �˻� */
	public void findByDept();
	/** ��� ������ ��� �˻� */
	public void listEmployee();
	/** �α��� */
	public EmployeeDTO login();
}
