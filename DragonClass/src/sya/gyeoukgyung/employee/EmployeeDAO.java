package sya.gyeoukgyung.employee;

import java.util.List;

import sya.gyeoukgyung.student.StudentDTO;

/**
 * DB�� Employee���̺�� ������ ����ü�� �������̽�
 */
public interface EmployeeDAO {
	/** ������ ��� */
	public int insertEmployee(EmployeeDTO dto);
	/** ������ ���(+��)*/
	public int insertEmployeeOP(EmployeeDTO dto);
	/** ������ ��й�ȣ ���� */
	public int updateEmployeePw(int infoNo, String pw);
	/** ������ ���� ����*/
	public int deleteEmployee(int employeeNo);
	/** �̸����� ������ �˻� (���Ե� �̸� ���) */
	public List<EmployeeDTO> findByName(String name);	
	/** �й����� ������ �˻�*/
	public EmployeeDTO findByEmployeeNo(int employeeNo);
	/** ���������� ������ �˻� */
	public List<EmployeeDTO> findByDept(int deptNo);
	/** ��� ������ ����Ʈ �˻� */
	public List<EmployeeDTO> listEmployee();
	/** �α��� */
	public EmployeeDTO login(int id, String pw);
	

}
