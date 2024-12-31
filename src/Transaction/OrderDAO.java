package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {
	private SQLUtil jdbcUltil = new SQLUtil();
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String sqlGetAll = "select * from orders";

	private String sqlInsert = "insert into orders(orderDate) values (CURRENT_TIMESTAMP)";

	public int insertOrder(Connection conn) throws SQLException {
		int generateID = -1;

		try {
			pstmt = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			if (pstmt.executeUpdate() > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					generateID = rs.getInt(1);
				}
			}
			if (generateID == -1) {
				conn.rollback();
			}
			return generateID;
		} finally {
			jdbcUltil.closeConnection(rs, null, pstmt, null);
		}
	}

	public ArrayList<Orders> getAll() throws SQLException {
		ArrayList<Orders> arr = new ArrayList<>();
		try {
			conn = jdbcUltil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlGetAll);
			while (rs.next()) {
				arr.add(new Orders(rs.getInt(1), rs.getDate(2)));
			}
		} finally {
			jdbcUltil.closeConnection(rs, stmt, pstmt, conn);
		}
		return arr;
	}
}
