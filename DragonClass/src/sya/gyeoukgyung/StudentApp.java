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
	 * �л� �α��� �޴�
	 */
	public void studentLogIn() {
		System.out.println("\n--�л��α��� Page--\n");

		// id�� ������ -2, pw�� Ʋ������ -1,
		// �α��ο� ���������� �ش� ȸ���� ȸ����ȣ
		try {
			dto = student.login();

			mainMenu();

		} catch (NullPointerException e) {
			System.out.println("�α��� ����! \n���� ȭ������ ���ư��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �л� ���� �޴� 1.���������� 2.��������
	 */
	private void mainMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--�л� ���θ޴�--");
			System.out.println("--[�л�]" + dto.getInfoDTO().getName() + "���� �����ϼ̽��ϴ�!--\n");
			do {
				System.out.println("1.���������� 2.�������� 3.�α׾ƿ�");
				System.out.print("�Է�> ");
				n = sc.nextInt();
			} while (n < 1 || n > 3);

			switch (n) {
			case 3:
				System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�.");
				return;
			case 1:
				mypageMenu();
				break;
			case 2:
				lectureManagementMenu();
				break;
			}
			System.out.println("�л� ���θ޴��� ���ư��ϴ�.");
		}
	}

	/**
	 * �л� ���������� �޴� 1.����������ȸ 2.������������ 3.��й�ȣ ���� 4.�ڷΰ���
	 */
	private void mypageMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--�л� ���������� �޴�--");
			do {
				System.out.println("1.����������ȸ 2.������������ 3.��й�ȣ ���� 4.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * �л� �������� �޴� 1.���ǰ˻� 2.������û 3.��û��� 4.�ڷΰ���
	 */
	private void lectureManagementMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--�л� �������� �޴�--");
			do {
				System.out.println("1.���ǰ˻� 2.������û 3.��û��� 4.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * ���ǰ˻� 1.�а��� 2.����� 3.�����ڵ� 4.������ 5.�ڷΰ���
	 */
	private void searchLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--�л� ��������> ���ǰ˻�--");
			do {
				System.out.println("1.�а��� 2.����� 3.�����ڵ� 4.������ 5.�ڷΰ���");
				System.out.print("�Է�> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				System.out.println("�л� �������� �޴��� ���ư��ϴ�.");
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
	 * ������û��� Ȯ�� 1.���� 2.�ڷΰ���
	 */
	private void searchLectureAddList() {
		try {
			int n = 0;
			while (true) {
				System.out.println("\n--�л� ��������> ������û���--");
				lectureApply.listLectureApplyByinfoNo(dto.getInfoNo());
				System.out.println("=========================");
				do {
					System.out.println("1.���� 2.�ڷΰ���");
					System.out.print("�Է�> ");
					n = sc.nextInt();
				} while (n < 1 || n > 2);

				switch (n) {
				case 2:
					System.out.println("�л� �������� �޴��� ���ư��ϴ�.");
					return;
				case 1:
					lectureApply.deleteLectureApply(dto.getInfoNo());
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("�л� �������� �޴��� ���ư��ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
