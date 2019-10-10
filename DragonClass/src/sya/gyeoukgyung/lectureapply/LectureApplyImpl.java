package sya.gyeoukgyung.lectureapply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LectureApplyImpl implements LectureApply {
	LectureApplyDAO dao = new LectureApplyDAOImpl();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/** ������û ��� */
	@Override
	public void insertLectureApply(int infoNo) {

	}

	/** ������û ���� ���� */
	@Override
	public void deleteLectureApply(int infoNo) {
		System.out.println("-- �� ������û ��� ����");
		List<Map<String, Object>> list = null;
		try {
		list = dao.listLectureApply(infoNo);
		Map<String, Object> map = null;

		Iterator<Map<String, Object>> iter = list.iterator();
if(list.size()==0) return;
		// ��ϵ� ������û ��� ���
		System.out.println("��ϵ� ������û ���:::");
		for (int i = 0; iter.hasNext(); i++) {
			map = iter.next();
			System.out.println(i + "\t");
			System.out.print(map.get("sub_name") + "\t");
			System.out.print(map.get("dept_name") + "\t");
			System.out.print(map.get("DIVISION") + "\t");
			System.out.print(map.get("name") + "\t");
			System.out.print(map.get("DAY") + "\t");
			System.out.print(map.get("STIME") + "\t");
			System.out.print(map.get("ETIME") + "\t");
			System.out.print(map.get("room_name") + "\t");
			System.out.print(map.get("CREDIT") + "\t");
			System.out.println();
		}
		
			System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > map.size());

			LectureApplyDTO dto = new LectureApplyDTO();
			dto.setStudentNo(infoNo);
			String lNo = (String) list.get(ch).get("LECTURE_NO");
			dto.setLectureNo(Integer.parseInt(lNo));

			int n = dao.deleteLectureApply(dto);

			if (n >= 1) {
				System.out.println("�������� ���� �Ϸ�.");
			} else {
				System.out.println("�������� ���� ����.");
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}catch (NullPointerException e) {
			System.out.println("������û ����� �������� �ʽ��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//
//	public static void main(String[] args) {
//		LectureApply la = new LectureApplyImpl();
//		la.deleteLectureApply(2);
//	}

	/** ��� ������û ��� �˻� */
	@Override
	public void listLectureApplyByinfoNo(int infoNo) {
		System.out.println("-- �� ������û ��� ��ȸ");
		// TODO: ���ǰ� �ְ�, ������ �ִٰ� ����.
		try {
		
		List<Map<String, Object>> list = new ArrayList<>();
		list = dao.listLectureApply(infoNo);
		Map<String, Object> map = null;

		Iterator<Map<String, Object>> iter = list.iterator();

		while (iter.hasNext()) {
			map = iter.next();
			System.out.print(map.get("sub_name") + "\t");
			System.out.print(map.get("dept_name") + "\t");
			System.out.print(map.get("DIVISION") + "\t");
			System.out.print(map.get("name") + "\t");
			System.out.print(map.get("DAY") + "\t");
			System.out.print(map.get("STIME") + "\t");
			System.out.print(map.get("ETIME") + "\t");
			System.out.print(map.get("room_name") + "\t");
			System.out.print(map.get("CREDIT") + "\t");

			System.out.println();

		}
		
		} catch (NullPointerException e) {
			System.out.println("������û ����� �������� �ʽ��ϴ�.");
			throw new NullPointerException();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
