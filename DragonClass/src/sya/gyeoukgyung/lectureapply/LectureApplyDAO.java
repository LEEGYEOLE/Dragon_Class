package sya.gyeoukgyung.lectureapply;

import java.util.List;
import java.util.Map;

/**
 * DB�� LectureApply���̺�� ������ ����ü�� �������̽�
 */
public interface LectureApplyDAO {
	/** ������û ��� */
	public int insertLectureApply(LectureApplyDTO dto);
	/** ������û ���� ���� */
	public int deleteLectureApply(LectureApplyDTO dto);
	/** ��� ������û ��� �˻� */
	public List<Map<String, Object>> listLectureApply(int infoNo);

}
