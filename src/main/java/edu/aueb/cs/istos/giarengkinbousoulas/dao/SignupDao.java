package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class SignupDao {
    public String registerUser(User registeredUser) {
        String email = registeredUser.getEmail();
        String password = registeredUser.getPassword();

        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DatabaseHandler.createConnection();
            String sql_query = "INSERT INTO ISTOS.USERS (USERNAME, PASSWORD) VALUES (:email, :password)";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                return "SUCCESS";
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        return "Sign-Up failed...!";
    }
}
