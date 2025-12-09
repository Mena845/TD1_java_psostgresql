package Class;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private final DBConnection db = new DBConnection();

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM product_category";
        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("product_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }


    public List<Product> getProductList(int page, int size) {
        List<Product> products = new ArrayList<>();

        String sql = """
            SELECT * FROM product
            ORDER BY id
            LIMIT ? OFFSET ?
        """;

        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, size);
            stmt.setInt(2, (page - 1) * size);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("id");
                products.add(new Product(productId, rs.getString("name"), rs.getDouble("price"), rs.getTimestamp("creation_datetime").toInstant(), getCategoriesByProduct(productId)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    private List<Category> getCategoriesByProduct(int productId) throws SQLException {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM product_category WHERE product_id = ?";
        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {categories.add(new Category(rs.getInt("id"), rs.getString("name"), productId));
            }
        }

        return categories;
    }


    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax) {
        List<Product> products = new ArrayList<>();
        String sql = """
            SELECT DISTINCT p.*
            FROM product p
            LEFT JOIN product_category c ON p.id = c.product_id
            WHERE ( ? IS NULL OR p.name ILIKE ? )
            AND ( ? IS NULL OR c.name ILIKE ? )
            AND ( ? IS NULL OR p.creation_datetime >= ? )
            AND ( ? IS NULL OR p.creation_datetime <= ? )
        """;

        try (Connection conn = db.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productName);
            stmt.setString(2, productName == null ? null : "%" + productName + "%");
            stmt.setString(3, categoryName);
            stmt.setString(4, categoryName == null ? null : "%" + categoryName + "%");
            stmt.setTimestamp(5, creationMin == null ? null : Timestamp.from(creationMin));
            stmt.setTimestamp(6, creationMin == null ? null : Timestamp.from(creationMin));
            stmt.setTimestamp(7, creationMax == null ? null : Timestamp.from(creationMax));
            stmt.setTimestamp(8, creationMax == null ? null : Timestamp.from(creationMax));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                products.add(new Product(productId, rs.getString("name"), rs.getDouble("price"), rs.getTimestamp("creation_datetime").toInstant(), getCategoriesByProduct(productId)
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    public List<Product> getProductsByCriteria(
            String productName, String categoryName,
            Instant creationMin, Instant creationMax,
            int page, int size) {
        List<Product> allFiltered = getProductsByCriteria(productName, categoryName, creationMin, creationMax);
        int from = (page - 1) * size;
        int to = Math.min(from + size, allFiltered.size());
        if (from > allFiltered.size()) return List.of();
        return allFiltered.subList(from, to);
    }
}

