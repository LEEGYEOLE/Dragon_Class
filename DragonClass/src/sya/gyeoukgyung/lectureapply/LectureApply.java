package sya.gyeoukgyung.lectureapply;
/**
 *	LectureApply�� ���õ� ����� �� DAOŬ��������� ������ ����ϴ� Service�������̽�.
 */
public interface LectureApply {
	/** ������û ��� */
	public void insertLectureApply(int infoNo);
	/** ������û ���� ����*/
	public void deleteLectureApply(int infoNo);
	/** ��� ������û ��� �˻� */
	public void listLectureApplyByinfoNo(int infoNo);
	
}
