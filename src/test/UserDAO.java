package test;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UserDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	private String sqlGetAll = "select * from user";
	private String sqlInsert = "insert into user(username, password, email) values (?,?,?)";
	private String sqlUpdate = "update user set username=?, password=?, email=? where id=?";
	private String sqlDelete = "delete from user where id=?";

	private static UserDAO instance;

	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<>();
		try {
			conn = DataSource.getInstance().getConnection();
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlGetAll);
				while (rs.next()) {
					// User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					// rs.getString(4));
					// users.add(user);
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
				return users;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
		}
	}

	public void insert(User user) {
		try {
			conn = DataSource.getInstance().getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(sqlInsert);
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail());

				if (pstmt.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Them nguoi dung thanh cong!", "Thong bao", 1);
					GUI.getInstance().showDataGetAll();
				} else {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Them nguoi dung that bai!", "Thong bao", 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
		}
	}

	public void update(User user) {
		try {
			conn = DataSource.getInstance().getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(sqlUpdate);
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail());
				pstmt.setInt(4, user.getID());

				if (pstmt.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Sua nguoi dung thanh cong!", "Thong bao", 1);
					GUI.getInstance().showDataGetAll();
				} else {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Sua nguoi dung that bai!", "Thong bao", 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
		}
	}

	public void delete(User user) {
		try {
			conn = DataSource.getInstance().getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(sqlDelete);
				pstmt.setInt(1, user.getID());

				if (pstmt.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Xoa nguoi dung thanh cong!", "Thong bao", 1);
					GUI.getInstance().showDataGetAll();
				} else {
					JOptionPane.showMessageDialog(GUI.getInstance(), "Xoa nguoi dung that bai!", "Thong bao", 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
		}
	}
}
