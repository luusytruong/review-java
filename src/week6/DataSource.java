package week6;

import java.sql.*;

import javax.swing.JOptionPane;

public class DataSource {
    private String url = "jdbc:mysql://localhost:3306/test";
    private String url2 = "jdbc:mysql://localhost:3306/java";
    private String username = "root";
    private String password = "";

    private static DataSource instance;

    private DataSource() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the nap Driver", "Thong bao", 2);
        }
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the ket noi CSDL", "Thong bao", 2);
            return null;
        }
    }

    public Connection getConn() {
        try {
            return DriverManager.getConnection(url2, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the ket noi CSDL", "Thong bao", 2);
            return null;
        }
    }

    public void closeConnection(Connection conn, ResultSet rs, Statement stmt, PreparedStatement pstmt) {
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
            JOptionPane.showMessageDialog(null, "Co loi khi dong tai nguyen", "Thong bao", 0);
        }
    }
}
