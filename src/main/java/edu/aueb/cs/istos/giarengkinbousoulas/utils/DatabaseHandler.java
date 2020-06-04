package edu.aueb.cs.istos.giarengkinbousoulas.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {

    public static Connection createConnection() {
        Connection connection = null;
//        String URL = "jdbc:mysql://localhost:3306/istos";
        String URL = "jdbc:h2:~/istos";
        String username = "";
        String password = "";
        try {
            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
                Class.forName("org.h2.Driver");
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
