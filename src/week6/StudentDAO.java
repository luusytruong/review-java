package week6;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    private String sqlGetAll = "select * from students";
    private String sqlUpdate = "update students set full_name=?, age=?, phone_number=?, address=? where id=?";
    private String sqlInsert = "insert into students(full_name, age, phone_number, address) values (?,?,?,?)";
    private String sqlDelete = "delete from students where id=?";

    private static StudentDAO instance;

    public static StudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    public ArrayList<Student> getAll() {
        try {
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
                }
                return students;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }

    public void update(Student student) {
        try {
            conn = DataSource.getInstance().getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sqlUpdate);
                pstmt.setString(1, student.getFullName());
                pstmt.setInt(2, student.getAge());
                pstmt.setString(3, student.getPhoneNumber());
                pstmt.setString(4, student.getAddress());
                pstmt.setInt(5, student.getId());

                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Cap nhat thong tin thanh cong", "Thong bao", 1);
                    GUI.getInstance().showDataGetAll();
                } else {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Cap nhat thong tin that bai", "Thong bao", 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }

    public void insert(Student student) {
        try {
            conn = DataSource.getInstance().getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sqlInsert);
                pstmt.setString(1, student.getFullName());
                pstmt.setInt(2, student.getAge());
                pstmt.setString(3, student.getPhoneNumber());
                pstmt.setString(4, student.getAddress());

                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Them moi sinh vien thanh cong", "Thong bao", 1);
                    GUI.getInstance().showDataGetAll();
                } else {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Them moi sinh vien that bai", "Thong bao", 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }

    public void delete(Student student) {
        try {
            conn = DataSource.getInstance().getConnection();
            if (conn != null) {
                pstmt = conn.prepareStatement(sqlDelete);
                pstmt.setInt(1, student.getId());

                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Xoa sinh vien thanh cong", "Thong bao", 1);
                    GUI.getInstance().showDataGetAll();
                } else {
                    JOptionPane.showMessageDialog(GUI.getInstance(), "Xoa sinh vien that bai", "Thong bao", 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }
}
