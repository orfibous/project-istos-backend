package edu.aueb.cs.istos.giarengkinbousoulas.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {
    public static Connection createConnection() {
        Connection connection = null;
        String URL = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = "root123";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException CNFE) {
                CNFE.printStackTrace();
            }
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Printing connection object " + connection);
        }
        catch (Exception E){
            E.printStackTrace();
        }
        return connection;
    }
}
