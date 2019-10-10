package sya.gyeoukgyung.department;

import java.util.List;

/**
 * DB�� Department���̺�� ������ ����ü�� �������̽�
 */
public interface DepartmentDAO {
	/** �а� ��� */
	public int insertDepartment(DepartmentDTO dto);
	/** �а� ���� ���� */
	public int updateDepartment(DepartmentDTO dto);
	/** �а� ���� ���� */
	public int deleteDepartment(int deptNo);
	/** �а������� �а��˻�  */
	public List<DepartmentDTO> findByDeptName(String deptName);
	/** ��� �а� ����Ʈ �˻� */
	public List<DepartmentDTO> listDepartment();
}
