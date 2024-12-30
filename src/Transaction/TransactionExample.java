package Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionExample {
	private SQLUtil sqlUtil = new SQLUtil();
	private ProductDAO productDao = new ProductDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private OrderDetailDAO detailDAO = new OrderDetailDAO();
	private Connection conn = null;

	public ProductDAO getProductDao() {
		return productDao;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public OrderDetailDAO getDetailDAO() {
		return detailDAO;
	}

	public void addOrder(ArrayList<OrderDetail> list) throws SQLException {
		if (list.isEmpty()) {
			System.out.println("order at least 1 product");
			return;
		}
		try {
			conn = sqlUtil.getConnection();
			conn.setAutoCommit(false);

			int orderID = orderDAO.insertOrder(conn);
			for (OrderDetail odd : list) {
				int productID = odd.getProductID();
				int quantity = odd.getQuantity();

				System.out.println("orderID " + orderID + ", product " + productID + ", quantity " + quantity);

				if (quantity < 1) {
					System.out.println("\n" + "product " + productID + ", invalid quantity, cancel orderID " + orderID);
					conn.rollback();
					return;
				}

				int stock = productDao.checkStock(productID);

				if (stock < quantity) {
					System.out.println("product " + productID + ", not enough stock, cancel orderID " + orderID);
					conn.rollback();
					return;
				}

				int currentStock = stock - quantity;
				boolean state = detailDAO.insertOrderDetail(conn, orderID, productID, quantity);

				if (state) {
					System.out.println("add product " + productID + ", for orderID " + orderID + " successful");
					state = productDao.updateStock(conn, productID, currentStock);
					if (state) {
						System.out.println("update stock successful");
					} else {
						System.out.println("update stock error");
					}
				} else {
					System.out.println("add product " + productID + ", for orderID " + orderID + " error");
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sqlUtil.closeConnection(null, null, null, conn);
		}
	}

}
