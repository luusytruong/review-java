package transactiondemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	private SQLUtil jdbcUltil = new SQLUtil();
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String sqlCheck = "select stock from product where id=?";
	private String sqlUpdate = "update product set stock=? where id=?";
	private String sqlGetAll = "select * from product";

	public int checkStock(int id) throws SQLException {
		int stock = 0;

		try {
			conn = jdbcUltil.getConnection();
			pstmt = conn.prepareStatement(sqlCheck);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				stock = rs.getInt(1);
			return stock;
		} finally {
			jdbcUltil.closeConnection(rs, stmt, pstmt, conn);
		}
	}

	public boolean updateStock(Connection conn, int id, int quantity) throws SQLException {
		boolean state = false;
		if (quantity < 0) {
			System.out.println("quantity invalid (must be > 0)");
			return false;
		}

		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, id);
			state = pstmt.executeUpdate() > 0;
		} finally {
			jdbcUltil.closeConnection(rs, stmt, pstmt, null);
		}
		return state;
	}

	public ArrayList<Product> getAll() throws SQLException {
		ArrayList<Product> arr = new ArrayList<>();
		try {
			conn = jdbcUltil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlGetAll);
			while (rs.next()) {
				arr.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} finally {
			jdbcUltil.closeConnection(rs, stmt, pstmt, conn);
		}
		return arr;
	}
}
