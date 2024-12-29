package week3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class OrdersDAO implements DAO<Orders> {
    // obj
    private DataSource dataSource = new DataSource();
    private ProductDAO productDAO = new ProductDAO();

    // init
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    // sql crud
    private String sqlGetAll = "select * from orders";
    private String sqlInsert = "insert into orders(productID, quantity) values (?,?)";
    private String sqlUpdate = "update orders set productID=?, quantity=? where id=?";
    private String sqlDelete = "delete from orders where id=?";

    public ArrayList<Orders> getAll() throws SQLException {
        ArrayList<Orders> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlGetAll);
            while (rs.next()) {
                list.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } finally {
            dataSource.closeConnection(rs, stmt, pstmt, conn);
        }
        return list;
    };

    public void insert(Orders obj) throws SQLException {
        System.out.println(
                MessageFormat.format("new order: product {0}, quantity {1}", obj.getProductID(), obj.getQuantity()));
        int productID = obj.getProductID();
        int quantity = obj.getQuantity();
        int stock = productDAO.checkStock(productID);
        int currentStock = stock - quantity;

        if (quantity <= 0) {
            System.out.println("quantity must be > 0");
            return;
        }

        if (stock < quantity) {
            System.out.println("not enough stock available");
            return;
        }
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setInt(1, productID);
            pstmt.setInt(2, quantity);
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("insert order successful");
                System.out.println("wait update stock: " + currentStock + ", for id: " + productID);

                productDAO.updateStock(conn, productID, currentStock);
                conn.commit();
                conn.setAutoCommit(true);
            } else {
                System.out.println("insert order error");
                conn.rollback();
            }
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(rs, stmt, pstmt, conn);
        }
    };

    public void update(Orders obj, int id) throws SQLException {
    };

    public void delete(int id) throws SQLException {
        System.out.println("waiting delete order id: " + id);

        if (id < 0) {
            System.out.println("id must be > 0");
            return;
        }
        // check stock
        int productID = -1;
        int quantity = -1;
        int stock = -1;
        int orderID = -1;
        try {
            ArrayList<Orders> list = this.getAll();
            for (Orders order : list) {
                if (order.getId() == id) {
                    orderID = order.getId();
                    productID = order.getProductID();
                    quantity = order.getQuantity();
                    System.out.println("order had product: " + productID + ", quantity: " + quantity);
                    break;
                }
            }
            if (orderID < 0) {
                System.out.println("order not found" + "\n");
                return;
            }
            stock = productDAO.checkStock(productID);
            int currentStock = stock + quantity;

            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("delete order successful");
                System.out.println("waiting update stock for product: " + productID + ", stock: " + currentStock);
                productDAO.updateStock(conn, productID, currentStock);
                conn.commit();
                conn.setAutoCommit(true);
            } else {
                System.out.println("delete order error" + "\n");
                conn.rollback();
            }

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(rs, stmt, pstmt, conn);
        }
    };
}