package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataRetrieverTest {

    private final DataRetriever dataRetriever = new DataRetriever();
    @Test
    void testGetAllCategories() throws SQLException {
        List<Category> categories = dataRetriever.getAllCategories();

        assertNotNull(categories, "La liste des catégories ne doit pas être null");
        assertFalse(categories.isEmpty(), "La liste des catégories ne doit pas être vide");
    }


    @Test
    void testGetProductList() throws SQLException {
        int page = 1;
        int size = 5;

        List<Product> products = dataRetriever.getProductList(page, size);

        assertNotNull(products, "La liste des produits ne doit pas être null");
        assertTrue(products.size() <= size, "La taille ne doit pas dépasser la pagination");
    }


    @Test
    void testGetProductsByCriteria() throws SQLException {
        String productName = null;
        String categoryName = null;
        Instant creationMin = null;
        Instant creationMax = null;

        List<Product> products = dataRetriever.getProductsByCriteria(
                productName,
                categoryName,
                creationMin,
                creationMax
        );

        assertNotNull(products, "La liste filtrée ne doit pas être null");
    }

    @Test
    void testGetProductsByCriteriaWithName() throws SQLException {
        List<Product> products = dataRetriever.getProductsByCriteria(
                "test",
                null,
                null,
                null
        );

        assertNotNull(products);
    }
}
