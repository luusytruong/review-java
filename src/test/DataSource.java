package test;

import java.sql.*;

import javax.swing.JOptionPane;

public class DataSource {
	private String url = "jdbc:mysql://localhost:3306/java_sinhvien_db";
	private String username = "root";
	private String password = "";

	private static DataSource instance;

	public static synchronized DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
		return instance;
	}

	public DataSource() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(GUI.getInstance(), "Khong the ket noi den CSDL", "Thong bao", 1);
			return null;
		}
	}

	public void closeConnection(Connection conn, ResultSet rs, Statement stmt, PreparedStatement pstmt) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
