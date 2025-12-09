package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/expense";
        String user = "postgres";
        String password = "tsilkaley2220";

        try (Connection ignored = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}


//JDBC = Java Database Connectivty
//c'est une bibliotheque de class dans java
//connecter uniquement quand on lance le programme

