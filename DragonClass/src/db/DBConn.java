package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Singleton Pattern
 */
public class DBConn {
	private static Connection conn;

	private DBConn() {
	}

	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@211.238.142.62:1521:xe";
		String user = "dongwoogi";
		String pwd = "dong";
		
		if (conn == null) {
			try {
				// OracleDriver 로딩 (JDK 6.0부터는 생략 가능, 자동로딩)
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// Connection 객체
				conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("동우기 연결완료~!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void close() {

		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			conn = null;
		}

	}
}