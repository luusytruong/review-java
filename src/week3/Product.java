package week3;

import java.text.MessageFormat;

public class Product {
    private int id;
    private String name;
    private int stock;

    public Product() {
    }

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return MessageFormat.format("id: {0}, name: {1}, stock: {2}", id, name, stock);
    }
}
