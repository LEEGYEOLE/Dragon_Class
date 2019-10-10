package sya.gyeoukgyung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApp {
	private Scanner sc = new Scanner(System.in);

	/**
	 * 메인 메뉴 1.학생로그인 2.교직원로그인 3.종료
	 */
	public MenuApp() {
		int n = 0;

		while (true) {
			try {
				System.out.println("<수강신청 관리 시스템>\n");
				do {
					System.out.println("1.학생로그인 2.교직원로그인 3.종료");
					System.out.print("입력> ");
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
				System.out.println("잘못된 입력입니다.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
