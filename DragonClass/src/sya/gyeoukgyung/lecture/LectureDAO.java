package sya.gyeoukgyung.lecture;

import java.util.HashMap;
import java.util.List;
/**
 *	Lecture�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface LectureDAO {
	/** ���� ��� */
	public int insertLecture(LectureDTO dto);
	/** ���� ���� ����*/
	public int deleteLecture(int lecNo);
	/** �а������� ���� �˻� */
	public List<HashMap<String, Object>> findByDept(String dept);
	/** �̼��������� ���� �˻� */
	public List<HashMap<String, Object>> findByDivision(String div);
	/** ��������� ���� �˻� (���Ե� �̸� ���) */
	public List<HashMap<String, Object>> findByLecName(String lecName);
	/** �����ڵ�� ���� �˻� */
	public List<HashMap<String, Object>> findByCode(String code);
	/** ���������� ���� �˻� */
	public List<HashMap<String, Object>> findByPname(String pname);
	/** ��� ���� ��� �˻� */
	public List<HashMap<String, Object>> listLecture();
	//���� �����ȸ, �а�����, �̼��������� ��ȸ, ���������, 
	//�����ڵ��, ����������, ���ǻ���
}
