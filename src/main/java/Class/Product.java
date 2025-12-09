package Class;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
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


    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price +
                ", creationDatetime=" + creationDatetime +
                ", categories=" + categories + "}";
    }
}
