package week3;

import java.text.MessageFormat;

public class Orders {
    private int id;
    private int productID;
    private int quantity;

    public Orders() {
    }

    public Orders(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public Orders(int id, int productID, int quantity) {
        this.id = id;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return MessageFormat.format("id: {0}, product id: {1}, quantity: {2}", id, productID, quantity);
    }
}
