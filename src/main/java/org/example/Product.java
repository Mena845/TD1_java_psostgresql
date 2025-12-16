package org.example;

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
    }

    public Product(int id, String name, double price, Instant creationDatetime) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Instant creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
