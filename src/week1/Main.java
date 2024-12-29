package week1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String hostName = "jdbc:mysql://localhost:3306/";
		String dbName = "java_sinhvien_db";
		String userName = "root";
		String password = "";
	 	Connection conn = Test.getMySQLConnection(hostName, dbName, userName, password);
	 	String sqlGetAll = "select * from students";
	 	Statement stmt = conn.createStatement();
	 	ResultSet rs = stmt.executeQuery(sqlGetAll);
	 	Test.showData(rs);
	}
}
