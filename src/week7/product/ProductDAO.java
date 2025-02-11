package week7.product;

import java.sql.*;
import java.util.ArrayList;
import week6.DataSource;

public class ProductDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private String sqlGetAll = "SELECT * FROM products";
    private String sqlInsert = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";
    private String sqlUpdate = "UPDATE products SET name = ?, price = ?, stock = ? WHERE id = ?";
    private String sqlDelete = "DELETE FROM products WHERE id = ?";

    public ArrayList<Product> getAll() {
        conn = DataSource.getInstance().getConn();
        if (conn == null) {
            return null;
        }
        ArrayList<Product> products = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlGetAll);
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
        return products;
    }

    public boolean insert(Product product) {
        conn = DataSource.getInstance().getConn();
        if (conn == null) {
            return false;
        }
        try {
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }

    public boolean update(Product product) {
        conn = DataSource.getInstance().getConn();
        if (conn == null) {
            return false;
        }
        try {
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            pstmt.setInt(4, product.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }

    public boolean delete(int id) {
        conn = DataSource.getInstance().getConn();
        if (conn == null) {
            return false;
        }
        try {
            pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DataSource.getInstance().closeConnection(conn, rs, stmt, pstmt);
        }
    }
}
