package org.example;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getDBConnection();
            if(conn != null && !conn.isClosed()){
                System.out.println("Connected to the database");
            }
            conn.close();
        }catch (SQLException e){
            System.out.println("Echec de la connexion");
            e.printStackTrace();
        }
    }
}