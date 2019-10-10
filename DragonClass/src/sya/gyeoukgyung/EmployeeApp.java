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
	 * ������ �α��� �޴�
	 */
	public void employeeLogIn() {
		System.out.println("\n--�������α��� Page--\n");

		// id�� ������ -2, pw�� Ʋ������ -1,
		// �α��ο� ���������� �ش� ȸ���� ȸ����ȣ
//			dto = employee.login();
//
//			if (dto != null && dto.getInfoNo() != -2 && dto.getInfoNo() != -1) {
//				if (dto.getInfoNo() == 1)
		dto = new EmployeeDTO();
		dto.setEmployeeNo(1);
		dto.setInfoNo(1);
		dto.getInfoDTO().setName("������");

		mainMenu();
//				else
//					System.out.println("������ ������ �����ϴ�.");
//			}else{
//	}	
		System.out.println("���� ȭ������ ���ư��ϴ�.");
		return;
	}

	/**
	 * ������ ���� �޴� 1.�а����� 2.�л����� 3.�������� 4.������� 5.���ǰ��� 6.����� 7.�α׾ƿ�
	 */
	private void mainMenu() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ ���θ޴�--");
			System.out.println("--[������]" + dto.getInfoDTO().getName() + "���� �����ϼ̽��ϴ�!--\n");
			do {
				System.out.println("1.�а����� 2.�л����� 3.�������� 4.������� 5.���ǰ��� 6.����� 7.�α׾ƿ�");
				System.out.print("�Է�> ");
				n = sc.nextInt();
			} while (n < 1 || n > 7);

			switch (n) {
			case 7:
				System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�.");
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
			System.out.println("������ ���θ޴��� ���ư��ϴ�.");
		}
	}

	/**
	 * ������ �а����� 1.�а���� 2.�а���ȸ 3.�а����� 4.�а����� 5.�ڷΰ���
	 */
	private void managementDept() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ �а����� �޴�--");
			do {
				System.out.println("1.�а���� 2.�а���ȸ 3.�а����� 4.�а����� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * ������ �л����� 1.�л���� 2.�л���ȸ 3.�л����� 4.�л����� 5.�ڷΰ���
	 */
	private void managementStudent() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ �л����� �޴�--");
			do {
				System.out.println("1.�л���� 2.�л���ȸ 3.�л����� 4.�л����� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
					System.out.println("1.�а� 2.�̸� 3.��ü 4.�ڷΰ���");
					System.out.print("�Է�> ");
					nn = sc.nextInt();
				} while (nn < 1 || nn > 4);

				switch (nn) {
				case 4:
					System.out.println("������ �л����� �޴��� ���ư��ϴ�.");
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
	 * ������ �������� 1.������� 2.������ȸ 3.�������� 4.�������� 5.�ڷΰ���
	 */
	private void managementEmployee() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ �������� �޴�--");
			do {
				System.out.println("1.������� 2.������ȸ 3.�������� 4.�������� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
					System.out.println("1.�а� 2.�̸� 3.��ü 4.�ڷΰ���");
					System.out.print("�Է�> ");
					nn = sc.nextInt();
				} while (nn < 1 || nn > 4);

				switch (nn) {
				case 4:
					System.out.println("������ �������� �޴��� ���ư��ϴ�.");
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
	 * ������ ������� 1.������ 2.������ȸ 3.������� 4.������� 5.�ڷΰ���
	 */
	private void managementSubject() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ ������� �޴�--");
			do {
				System.out.println("1.������ 2.������ȸ 3.������� 4.������� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * ������ ���ǰ��� 1.���ǵ�� 2.������ȸ 3.���Ǽ��� 4.���ǻ��� 5.�ڷΰ���
	 */
	private void managementLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ ���ǰ��� �޴�--");
			do {
				System.out.println("1.���ǵ�� 2.������ȸ 3.���Ǽ��� 4.���ǻ��� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * ������ ����� 1.���� 2.����ȸ 3.����� 4.����� 5.�ڷΰ���
	 */
	private void managementRoom() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ ����� �޴�--");
			do {
				System.out.println("1.���� 2.����ȸ 3.����� 4.����� 5.�ڷΰ���");
				System.out.print("�Է�> ");
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
	 * ���ǰ˻� 1.�а��� 2.����� 3.�����ڵ� 4.��ü 5.�ڷΰ���
	 */
	private void searchLecture() {
		int n = 0;

		while (true) {
			System.out.println("\n--������ ���ǰ���> ���ǰ˻�--");
			do {
				System.out.println("1.�а��� 2.����� 3.�����ڵ� 4.��ü 5.�ڷΰ���");
				System.out.print("�Է�> ");
				n = sc.nextInt();
			} while (n < 1 || n > 5);

			switch (n) {
			case 5:
				System.out.println("������ ���ǰ��� �޴��� ���ư��ϴ�.");
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
