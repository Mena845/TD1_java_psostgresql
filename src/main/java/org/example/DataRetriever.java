package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT * FROM product_category";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                categories.add(
                        new Category(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
                );
            }
        }
        return categories;
    }


    public List<Product> getProductList(int page, int size) throws SQLException {
        List<Product> products = new ArrayList<>();

        int offset = (page - 1) * size;

        String query =
                "SELECT * FROM product " +
                        "ORDER BY id DESC " +
                        "LIMIT ? OFFSET ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, size);
            ps.setInt(2, offset);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getDouble("price"),
                                rs.getTimestamp("creation_datetime").toInstant()
                        )
                );
            }
        }
        return products;
    }


    public List<Product> getProductsByCriteria(
            String productName,
            String categoryName,
            Instant creationMin,
            Instant creationMax) throws SQLException {

        List<Product> products = new ArrayList<>();

        StringBuilder query = new StringBuilder(
                "SELECT DISTINCT p.* FROM product p " +
                        "LEFT JOIN product_category c ON p.id = c.product_id " +
                        "WHERE 1=1"
        );

        if (productName != null)
            query.append(" AND p.name ILIKE ?");
        if (categoryName != null)
            query.append(" AND c.name ILIKE ?");
        if (creationMin != null)
            query.append(" AND p.creation_datetime >= ?");
        if (creationMax != null)
            query.append(" AND p.creation_datetime <= ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query.toString())) {

            int index = 1;

            if (productName != null)
                ps.setString(index++, "%" + productName + "%");

            if (categoryName != null)
                ps.setString(index++, "%" + categoryName + "%");

            if (creationMin != null)
                ps.setTimestamp(index++, Timestamp.from(creationMin));

            if (creationMax != null)
                ps.setTimestamp(index++, Timestamp.from(creationMax));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getDouble("price"),
                                rs.getTimestamp("creation_datetime").toInstant()
                        )
                );
            }
        }
        return products;
    }
}
