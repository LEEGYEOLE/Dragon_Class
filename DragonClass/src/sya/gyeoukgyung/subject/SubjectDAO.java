package sya.gyeoukgyung.subject;

import java.util.HashMap;
import java.util.List;

public interface SubjectDAO {
	/** ���� ��� */
	public int insertSubject(SubjectDTO dto);
	/** ���� ���� ����*/
	public int deleteSubject(int subNo);
	/** ��������� ���� �˻� (���Ե� �̸� ���) */
	public List<HashMap<String, Object>> findBySubName(String name);
	/** �����ȣ�� ���� �˻� */
	public List<HashMap<String, Object>> findBySubNo(int subNo);
	/** �����ڵ�� ���� �˻� (���Ե� �����ڵ� ���) */
	public List<HashMap<String, Object>> findBySubCode(String subCode);
	/** ������ȣ�� ���� �˻� */
	public List<HashMap<String, Object>> findByDept(int deptNo);
	/** ��� ���� ��� �˻� */
	public List<HashMap<String, Object>> listSubject();

}
