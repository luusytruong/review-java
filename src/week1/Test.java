package week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class Test {
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Drriver");
		Connection conn = DriverManager.getConnection(hostName + dbName, userName, password);
		if (conn != null) {
			return conn;
		}
		return null;
	}

	public static void showData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			System.out.println("data exist");
			rs.previous();
			while (rs.next()) {
				System.out.println(MessageFormat.format("id: {0}, name: {1}, age: {2}, grade: {3}", rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} else {
			System.out.println("data empty");
		}
	}
}
