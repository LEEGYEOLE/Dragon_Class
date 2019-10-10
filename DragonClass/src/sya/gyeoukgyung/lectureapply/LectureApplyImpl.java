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

	/** 수강신청 등록 */
	@Override
	public void insertLectureApply(int infoNo) {

	}

	/** 수강신청 정보 삭제 */
	@Override
	public void deleteLectureApply(int infoNo) {
		System.out.println("-- 내 수강신청 목록 삭제");
		List<Map<String, Object>> list = null;
		try {
		list = dao.listLectureApply(infoNo);
		Map<String, Object> map = null;

		Iterator<Map<String, Object>> iter = list.iterator();
if(list.size()==0) return;
		// 등록된 수강신청 목록 출력
		System.out.println("등록된 수강신청 목록:::");
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
		
			System.out.println("삭제할 과목의 번호를 입력하세요.");
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
				System.out.println("수강과목 삭제 완료.");
			} else {
				System.out.println("수강과목 삭제 실패.");
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("잘못된 입력입니다.");
		}catch (NullPointerException e) {
			System.out.println("수강신청 목록이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//
//	public static void main(String[] args) {
//		LectureApply la = new LectureApplyImpl();
//		la.deleteLectureApply(2);
//	}

	/** 모든 수강신청 목록 검색 */
	@Override
	public void listLectureApplyByinfoNo(int infoNo) {
		System.out.println("-- 내 수강신청 목록 조회");
		// TODO: 강의가 있고, 유저가 있다고 가정.
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
			System.out.println("수강신청 목록이 존재하지 않습니다.");
			throw new NullPointerException();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
