package week2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAO {
	private String sqlGetAll = "select * from user";
	private String sqlInsert = "insert into user(username, password, email) values (?,?,?)";
	private String sqlUpdate = "update user set username=?, password=?, email=? where id=?";
	private String sqlDelete = "delete from user where id=?";

	private JDBCUtil jdbcUtil = new JDBCUtil();

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = jdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlGetAll);
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(user);
			}
		} finally {
			jdbcUtil.closeConnection(rs, stmt, pstmt, conn);
		}
		return list;
	};

	public int insert(User user) throws SQLException, ClassNotFoundException {
		int key = -1;
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());

			if (pstmt.executeUpdate() > 0) {
				System.out.println("insert successful");
				rs = pstmt.getGeneratedKeys();
				rs.next();
				key = rs.getInt(1);
			} else {
				System.out.println("insert error");
			}
		} finally {
			jdbcUtil.closeConnection(rs, stmt, pstmt, conn);
		}
		return key;
	};

	public void update(User user, int id) throws SQLException, ClassNotFoundException {
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, id);

			if (pstmt.executeUpdate() > 0) {
				System.out.println("update successful");
			} else {
				System.out.println("update error");
			}
		} finally {
			jdbcUtil.closeConnection(rs, stmt, pstmt, conn);
		}
	};

	public void delete(int id) throws SQLException, ClassNotFoundException {
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setInt(1, id);

			if (pstmt.executeUpdate() > 0) {
				System.out.println("delete successful");
			} else {
				System.out.println("delete error");
			}
		} finally {
			jdbcUtil.closeConnection(rs, stmt, pstmt, conn);
		}
	};
}
