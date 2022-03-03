package productlist_runbyadmin.model;

import java.util.Properties;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private int total;
    private static int idNumber = 1;

    public Product(int id, String name, int price, int quantity, String description, int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.total = total;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quality) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total = price * quantity ;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
