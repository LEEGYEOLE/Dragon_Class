package sya.gyeoukgyung;

import java.util.Scanner;

import sya.gyeoukgyung.lecture.Lecture;
import sya.gyeoukgyung.lecture.LectureImpl;
import sya.gyeoukgyung.lectureapply.LectureApply;
import sya.gyeoukgyung.lectureapply.LectureApplyImpl;
import sya.gyeoukgyung.student.Student;
import sya.gyeoukgyung.student.StudentDTO;
import sya.gyeoukgyung.student.StudentImpl;

public class StudentApp {
	Student student = new StudentImpl();
	Lecture lecture = new LectureImpl();
	LectureApply lectureApply = new LectureApplyImpl();
	private Scanner sc = new Scanner(System.in);
	private StudentDTO dto = null;

	/**
	 * 학생 로그인 메뉴
	 */
	public void studentLogIn() {
		System.out.println("\n--학생로그인 Page--\n");

		// id가 없으면 -2, pw가 틀렸으면 -1,
		// 로그인에 성공했으면 해당 회원의 회원번호
		try {
			dto = student.login();

			mainMenu();

		} catch (NullPointerException e) {
			System.out.println("로그인 실패! \n메인 화면으로 돌아갑니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 학생 메인 메뉴 1.마이페이지 2.수강관리
	 */
	private void mainMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--학생 메인메뉴--");
			System.out.println("--[학생]" + dto.getInfoDTO().getName() + "으로 접속하셨습니다!--\n");
			do {
				System.out.println("1.마이페이지 2.수강관리 3.로그아웃");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 3);

			switch (n) {
			case 3:
				System.out.println("로그아웃이 완료되었습니다.");
				return;
			case 1:
				mypageMenu();
				break;
			case 2:
				lectureManagementMenu();
				break;
			}
			System.out.println("학생 메인메뉴로 돌아갑니다.");
		}
	}

	/**
	 * 학생 마이페이지 메뉴 1.개인정보조회 2.개인정보수정 3.비밀번호 변경 4.뒤로가기
	 */
	private void mypageMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--학생 마이페이지 메뉴--");
			do {
				System.out.println("1.개인정보조회 2.개인정보수정 3.비밀번호 변경 4.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 4);

			switch (n) {
			case 4:

				return;
			case 1:
				student.searchStudent(dto);
				break;
			case 2:
				student.updateStudent(dto);
				break;
			case 3:
				student.updateStudentPw(dto);
				break;
			}
		}
	}

	/**
	 * 학생 수강관리 메뉴 1.강의검색 2.수강신청 3.신청목록 4.뒤로가기
	 */
	private void lectureManagementMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--학생 수강관리 메뉴--");
			do {
				System.out.println("1.강의검색 2.수강신청 3.신청목록 4.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 4);

			switch (n) {
			case 4:
				return;
			case 1:
				searchLecture();
				break;
			case 2:
				lectureApply.insertLectureApply(dto.getInfoNo());
				break;
			case 3:
				searchLectureAddList();
				break;
			}
		}
	}

	/**
	 * 강의검색 1.학과별 2.과목명 3.과목코드 4.교수명 5.뒤로가기
	 */
	private void searchLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--학생 수강관리> 강의검색--");
			do {
				System.out.println("1.학과별 2.과목명 3.과목코드 4.교수명 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				System.out.println("학생 수강관리 메뉴로 돌아갑니다.");
				return;
			case 1:
				lecture.findByDept();
				break;
			case 2:
				lecture.findByLecName();
				break;
			case 3:
				lecture.findByCode();
				break;
			case 4:
				lecture.findByPName();
				break;
			}
		}
	}

	/**
	 * 수강신청목록 확인 1.삭제 2.뒤로가기
	 */
	private void searchLectureAddList() {
		try {
			int n = 0;
			while (true) {
				System.out.println("\n--학생 수강관리> 수강신청목록--");
				lectureApply.listLectureApplyByinfoNo(dto.getInfoNo());
				System.out.println("=========================");
				do {
					System.out.println("1.삭제 2.뒤로가기");
					System.out.print("입력> ");
					n = sc.nextInt();
				} while (n < 1 || n > 2);

				switch (n) {
				case 2:
					System.out.println("학생 수강관리 메뉴로 돌아갑니다.");
					return;
				case 1:
					lectureApply.deleteLectureApply(dto.getInfoNo());
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("학생 수강관리 메뉴로 돌아갑니다.");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
