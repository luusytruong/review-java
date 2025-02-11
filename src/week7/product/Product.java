package week7.product;

public class Product {
    private int id;
    private String name;
    private int price, stock;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", price=" + price + ", stock=" + stock + ", name=" + name + "]";
    }
}
