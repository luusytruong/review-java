package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDetailDAO {
	private SQLUtil jdbcUltil = new SQLUtil();
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String sqlGetAll = "select * from orderdetail";
	private String sqlInsert = "insert into orderdetail(orderID, productID, quantity) values (?,?,?)";

	public boolean insertOrderDetail(Connection conn, int orderId, int productID, int quantity) throws SQLException {
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, productID);
			pstmt.setInt(3, quantity);
			if (pstmt.executeUpdate() > 0) {
				return true;
			} else {
				conn.rollback();
				return false;
			}
		} finally {
			jdbcUltil.closeConnection(null, null, pstmt, null);
		}
	}

	public ArrayList<OrderDetail> getAll() throws SQLException {
		ArrayList<OrderDetail> arr = new ArrayList<>();
		try {
			conn = jdbcUltil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlGetAll);
			while (rs.next()) {
				arr.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
		} finally {
			jdbcUltil.closeConnection(rs, stmt, pstmt, conn);
		}
		return arr;
	}
}
