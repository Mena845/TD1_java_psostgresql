package org.example;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       try (Connection conn = DBConnection.getConnection()){
            System.out.println("Connected to the database");
        }catch (Exception e){
            System.out.println("Connection Failed");
        }

        DataRetriever dr=new DataRetriever();
        System.out.println("Categories");
        dr.getAllCategories().forEach(System.out::println);

        System.out.println("Pagination");
        dr.getProductList(1,2).forEach(System.out::println);

        System.out.println("Filtre");
        dr.getProductsByCriteria("Mac" , "Informatique" , null , null)
                .forEach(System.out::println);
   }



}