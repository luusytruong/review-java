package week6;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class StudentDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    private String sqlGetAll = "select * from students";

    private static StudentDAO instance;

    public static StudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    public ArrayList<Student> getAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        conn = DataSource.getInstance().getConnection();
        if (conn != null) {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlGetAll);
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5));
                students.add(student);
                System.out.println(student);
            }
        }
        return students;
    }
}
