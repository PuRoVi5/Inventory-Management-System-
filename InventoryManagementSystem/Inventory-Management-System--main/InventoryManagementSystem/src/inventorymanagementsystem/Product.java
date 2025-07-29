package inventorymanagementsystem;

public class Product {
    private int id;
    private String type;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String type, String name, int quantity, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
