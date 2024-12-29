package week3;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ProductDAO implements DAO<Product> {
    private DataSource dataSource = new DataSource();
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    // sql crud
    private String sqlGetAll = "select * from product";
    private String sqlInsert = "insert into product(name, stock) values (?,?)";
    private String sqlUpdate = "update product set name=?, stock=? where id=?";
    private String sqlDelete = "delete from product where id=?";

    // sql check, update stock
    private String sqlCheckStock = "select stock from product where id=?";
    private String sqlUpdateStock = "update product set stock=? where id=?";

    public ArrayList<Product> getAll() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlGetAll);
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } finally {
            dataSource.closeConnection(rs, stmt, pstmt, conn);
        }
        return list;
    };

    public void insert(Product obj) throws SQLException {
    };

    public void update(Product obj, int id) throws SQLException {
    };

    public void delete(int id) {
    };

    public int checkStock(int id) throws SQLException {
        int stock = -1;
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sqlCheckStock);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                stock = rs.getInt(1);
            }
        } finally {
            dataSource.closeConnection(rs, stmt, pstmt, conn);
        }
        return stock;
    }

    public void updateStock(Connection conn, int id, int quantity) throws SQLException {
        try {
            this.conn = conn;
            pstmt = this.conn.prepareStatement(sqlUpdateStock);
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("update stock successful");
            } else {
                System.out.println("update stock error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }
}
