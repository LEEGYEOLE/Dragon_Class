package sya.gyeoukgyung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApp {
	private Scanner sc = new Scanner(System.in);

	/**
	 * ���� �޴� 1.�л��α��� 2.�������α��� 3.����
	 */
	public MenuApp() {
		int n = 0;

		while (true) {
			try {
				System.out.println("<������û ���� �ý���>\n");
				do {
					System.out.println("1.�л��α��� 2.�������α��� 3.����");
					System.out.print("�Է�> ");
					n = sc.nextInt();
				} while (n < 1 || n > 3);

				switch (n) {
				case 3:
					sc.close();
					System.exit(0);
				case 1:
					new StudentApp().studentLogIn();
					break;
				case 2:
					new EmployeeApp().employeeLogIn();
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
