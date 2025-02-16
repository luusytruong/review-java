package week7.movie;

import java.sql.*;
import java.sql.SQLException;

public class DataSource {
    private String dns = "jdbc:mysql://localhost:3306/test";
    private String user = "root", password = "";

    private static DataSource instance; // thể hiện của class DataSource

    private DataSource() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized static DataSource getInstance() {
        // nếu thể hiện chưa được tạo, khởi tạo
        if (instance == null) {
            instance = new DataSource();
        }
        // trả về thể hiện
        return instance;
    }

    public Connection getConn() {
        try {
            return DriverManager.getConnection(dns, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeResource(ResultSet rs, Statement stmt, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
