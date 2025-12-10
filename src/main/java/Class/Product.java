package Class;

import java.time.Instant;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private Instant creationDatetime;
    private List<Category> categories;

    public Product(int id, String name, double price, Instant creationDatetime, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDatetime = creationDatetime;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Instant getCreationDatetime() {
        return creationDatetime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCreationDatetime(Instant creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creationDatetime=" + creationDatetime +
                ", categories=" + categories +
                '}';
    }
}
