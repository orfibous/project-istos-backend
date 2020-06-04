package edu.aueb.cs.istos.giarengkinbousoulas.dao;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.*;

public class UserDaoImpl {
    public String authenticateUser(User user) throws SQLException {
        String email = user.getEmail();
        String password = user.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        String emailDB = "";
        String passwordDB = "";
        int userID;

        try {
            connection = DatabaseHandler.createConnection();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT * FROM ISTOS.USERS;");
            while(results.next()){
                userID = results.getInt("USER_ID");
                emailDB = results.getString("USERNAME");
                passwordDB = results.getString("PASSWORD");
                if (email.equals(emailDB) && password.equals(passwordDB)){
                    connection.close();
                    user.setID(userID);
                    return "SUCCESS";
                }
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return "Invalid user credentials";
    }
}
