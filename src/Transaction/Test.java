package Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
	private String sqlInsert = "insert into orders(orderDate) values (?)";
	private SQLUtil jdbcUltil = new SQLUtil();

	public boolean insertOrder(Date date) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affected = -1;

		try {
			conn = jdbcUltil.getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(sqlInsert);

				pstmt.setDate(1, date);

				affected = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUltil.closeConnection(null, pstmt, pstmt, conn);
		}
		return affected > 0;
	}
}
