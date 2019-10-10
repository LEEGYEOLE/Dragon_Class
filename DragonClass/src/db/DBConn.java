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
				// OracleDriver �ε� (JDK 6.0���ʹ� ���� ����, �ڵ��ε�)
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// Connection ��ü
				conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("����� ����Ϸ�~!");
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