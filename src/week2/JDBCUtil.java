package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private String url = "jdbc:mysql://localhost:3306/java_sinhvien_db";
	private String username = "root";
	private String password = "";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public void closeConnection(ResultSet rs, Statement stmt, PreparedStatement pstmt, Connection conn)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (pstmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
