package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "select * from category";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        }
        return categories;
    }



    public List<Product> getProductList (int page , int size) throws SQLException {
        List<Product> products = new ArrayList<>();
        int offset = (page - 1) * size;
        String query = "select * from product order by id desc limit ?  offset ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, size );
            ps.setInt(2, offset );

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getTimestamp("creation_datetime").toInstant()
                ));
            }
        }
        return products;
    }

}
