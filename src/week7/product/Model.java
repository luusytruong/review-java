package week7.product;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Model {
    public DefaultTableModel getModel(ArrayList<Product> products) {
        Object[] columnName = { "Ma san pham", "Ten san pham", "Gia", "So luong" };
        Object[][] data = new Object[products.size()][columnName.length];
        for (Product product : products) {
            data[products.indexOf(product)][0] = product.getId();
            data[products.indexOf(product)][1] = product.getName();
            data[products.indexOf(product)][2] = product.getPrice();
            data[products.indexOf(product)][3] = product.getStock();
        }
        return new DefaultTableModel(data, columnName);
    }
}
