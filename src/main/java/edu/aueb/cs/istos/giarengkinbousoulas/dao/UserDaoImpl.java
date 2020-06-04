package edu.aueb.cs.istos.giarengkinbousoulas.dao;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.*;

public class UserDaoImpl {
    public String authenticateUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        String emailDB = "";
        String passwordDB = "";

        try {
            connection = DatabaseHandler.createConnection();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT * FROM accounts");
            while(results.next()){
                emailDB = results.getString("email");
                passwordDB = results.getString("password");
                if (email.equals(emailDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
