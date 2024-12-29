package week3;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main<T> {
    public void showData(ArrayList<T> obj, boolean title) {
        System.out.println(title ? "LIST PRODUCT"
                : "LIST ORDER");
        if (!obj.isEmpty()) {
            for (T item : obj) {
                System.out.println(item);
            }
        } else {
            System.out.println("empty");
        }
    }

    public static void main(String[] args) throws SQLException {
        Main<Product> mainProduct = new Main<>();
        Main<Orders> mainOrders = new Main<>();

        ProductDAO productDAO = new ProductDAO();
        OrdersDAO ordersDAO = new OrdersDAO();

        mainProduct.showData(productDAO.getAll(), true);
        mainOrders.showData(ordersDAO.getAll(), false);
        Orders orders = new Orders(5, 44);
        // ordersDAO.insert(orders);
        orders = new Orders(2, 16);
        // ordersDAO.insert(orders);
        ordersDAO.delete(11);
        ordersDAO.delete(12);

        mainProduct.showData(productDAO.getAll(), true);
        mainOrders.showData(ordersDAO.getAll(), false);
    }
}
