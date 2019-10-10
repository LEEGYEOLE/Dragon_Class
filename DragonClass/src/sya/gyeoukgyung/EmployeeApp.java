package sya.gyeoukgyung;

import java.util.Scanner;

import sya.gyeoukgyung.department.Department;
import sya.gyeoukgyung.department.DepartmentImpl;
import sya.gyeoukgyung.employee.Employee;
import sya.gyeoukgyung.employee.EmployeeDTO;
import sya.gyeoukgyung.employee.EmployeeImpl;
import sya.gyeoukgyung.lecture.Lecture;
import sya.gyeoukgyung.lecture.LectureImpl;
import sya.gyeoukgyung.room.Room;
import sya.gyeoukgyung.room.RoomImpl;
import sya.gyeoukgyung.student.Student;
import sya.gyeoukgyung.student.StudentImpl;
import sya.gyeoukgyung.subject.Subject;
import sya.gyeoukgyung.subject.SubjectImpl;

public class EmployeeApp {
	private Student student = new StudentImpl();
	private Room room = new RoomImpl();
	private Subject subject = new SubjectImpl();
	private Lecture lecture = new LectureImpl();
	private Department department = new DepartmentImpl();
	private Employee employee = new EmployeeImpl();

	private Scanner sc = new Scanner(System.in);
	private EmployeeDTO dto = null;

	/**
	 * 교직원 로그인 메뉴
	 */
	public void employeeLogIn() {
		System.out.println("\n--교직원로그인 Page--\n");

		// id가 없으면 -2, pw가 틀렸으면 -1,
		// 로그인에 성공했으면 해당 회원의 회원번호
//			dto = employee.login();
//
//			if (dto != null && dto.getInfoNo() != -2 && dto.getInfoNo() != -1) {
//				if (dto.getInfoNo() == 1)
		dto = new EmployeeDTO();
		dto.setEmployeeNo(1);
		dto.setInfoNo(1);
		dto.getInfoDTO().setName("관리자");

		mainMenu();
//				else
//					System.out.println("교수는 권한이 없습니다.");
//			}else{
//	}	
		System.out.println("메인 화면으로 돌아갑니다.");
		return;
	}

	/**
	 * 교직원 메인 메뉴 1.학과관리 2.학생관리 3.교수관리 4.과목관리 5.강의관리 6.방관리 7.로그아웃
	 */
	private void mainMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 메인메뉴--");
			System.out.println("--[교직원]" + dto.getInfoDTO().getName() + "으로 접속하셨습니다!--\n");
			do {
				System.out.println("1.학과관리 2.학생관리 3.교수관리 4.과목관리 5.강의관리 6.방관리 7.로그아웃");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 7);

			switch (n) {
			case 7:
				System.out.println("로그아웃이 완료되었습니다.");
				return;
			case 1:
				managementDept();
				break;
			case 2:
				managementStudent();
				break;
			case 3:
				managementEmployee();
				break;
			case 4:
				managementSubject();
				break;
			case 5:
				managementLecture();
				break;
			case 6:
				managementRoom();
				break;
			}
			System.out.println("교직원 메인메뉴로 돌아갑니다.");
		}
	}

	/**
	 * 교직원 학과관리 1.학과등록 2.학과조회 3.학과수정 4.학과삭제 5.뒤로가기
	 */
	private void managementDept() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 학과관리 메뉴--");
			do {
				System.out.println("1.학과등록 2.학과조회 3.학과수정 4.학과삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				department.insertDepartment();
				break;
			case 2:
				department.listDepartment();
				break;
			case 3:
				department.updateDepartment();
				break;
			case 4:
				department.deleteDepartment();
				break;
			}
		}
	}

	/**
	 * 교직원 학생관리 1.학생등록 2.학생조회 3.학생수정 4.학생삭제 5.뒤로가기
	 */
	private void managementStudent() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 학생관리 메뉴--");
			do {
				System.out.println("1.학생등록 2.학생조회 3.학생수정 4.학생삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				student.insertStudent();
				break;
			case 2:
				int nn;
				do {
					System.out.println("1.학과 2.이름 3.전체 4.뒤로가기");
					System.out.print("입력> ");
					nn = sc.nextInt();
				} while (nn < 1 || nn > 4);

				switch (nn) {
				case 4:
					System.out.println("교직원 학생관리 메뉴로 돌아갑니다.");
					break;
				case 1:
					student.findByDept();
					break;
				case 2:
					student.findByName();
					break;
				case 3:
					student.listStudent();
					break;
				}
				break;
			case 3:
				student.updateStudentPw();
				break;
			case 4:
				student.deleteStudent();
				break;
			}
		}
	}

	/**
	 * 교직원 교수관리 1.교수등록 2.교수조회 3.교수수정 4.교수삭제 5.뒤로가기
	 */
	private void managementEmployee() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 교수관리 메뉴--");
			do {
				System.out.println("1.교수등록 2.교수조회 3.교수수정 4.교수삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				employee.insertEmployee();
				break;
			case 2:
				int nn;
				do {
					System.out.println("1.학과 2.이름 3.전체 4.뒤로가기");
					System.out.print("입력> ");
					nn = sc.nextInt();
				} while (nn < 1 || nn > 4);

				switch (nn) {
				case 4:
					System.out.println("교직원 교수관리 메뉴로 돌아갑니다.");
					break;
				case 1:
					employee.findByDept();
					break;
				case 2:
					employee.findByName();
					break;
				case 3:
					employee.listEmployee();
					break;
				}
				break;
			case 3:
				employee.updateEmployeePw();
				break;
			case 4:
				employee.deleteEmployee();
				break;
			}
		}
	}

	/**
	 * 교직원 과목관리 1.과목등록 2.과목조회 3.과목수정 4.과목삭제 5.뒤로가기
	 */
	private void managementSubject() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 과목관리 메뉴--");
			do {
				System.out.println("1.과목등록 2.과목조회 3.과목수정 4.과목삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				subject.insertSubject();
				break;
			case 2:
				subject.listSubject();
				break;
			case 3:

				break;
			case 4:
				subject.deleteSubject();
				break;
			}
		}
	}

	/**
	 * 교직원 강의관리 1.강의등록 2.강의조회 3.강의수정 4.강의삭제 5.뒤로가기
	 */
	private void managementLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 강의관리 메뉴--");
			do {
				System.out.println("1.강의등록 2.강의조회 3.강의수정 4.강의삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				lecture.insertLecture();
				break;
			case 2:
				searchLecture();
				break;
			case 3:

				break;
			case 4:
				lecture.deleteLecture();
				break;
			}
		}
	}

	/**
	 * 교직원 방관리 1.방등록 2.방조회 3.방수정 4.방삭제 5.뒤로가기
	 */
	private void managementRoom() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 방관리 메뉴--");
			do {
				System.out.println("1.방등록 2.방조회 3.방수정 4.방삭제 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				return;
			case 1:
				room.insertRoom();
				break;
			case 2:
				room.listRoom();
				break;
			case 3:

				break;
			case 4:
				room.deleteRoom();
				break;
			}
		}
	}

	/**
	 * 강의검색 1.학과별 2.과목명 3.과목코드 4.전체 5.뒤로가기
	 */
	private void searchLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--교직원 강의관리> 강의검색--");
			do {
				System.out.println("1.학과별 2.과목명 3.과목코드 4.전체 5.뒤로가기");
				System.out.print("입력> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				System.out.println("교직원 강의관리 메뉴로 돌아갑니다.");
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
				lecture.listLecture();
				break;
			}
		}
	}
}
