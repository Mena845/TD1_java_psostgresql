package org.example;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()){
            System.out.println("Connected to the database");
        }catch (Exception e){
            System.out.println("Connection Failed");
        }
    }
}