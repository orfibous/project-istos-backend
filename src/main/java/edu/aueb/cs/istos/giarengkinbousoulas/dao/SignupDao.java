package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.*;

@SuppressWarnings("ALL")
public class SignupDao {
    public String registerUser(User registeredUser) throws SQLException {
        String email = registeredUser.getEmail();
        String password = registeredUser.getPassword();

        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = DatabaseHandler.createConnection();
            String sql_query;
//            String emailForQuery = email.replace("@", "?"); //TODO make check if an email is already registered
//            emailForQuery = emailForQuery.replace(".","?");
//            System.out.println(emailForQuery);
//            sql_query = "SELECT * FROM ISTOS.USERS WHERE USERNAME = ?";
//            PreparedStatement statement = connection.prepareStatement(sql_query);
//            statement.setString(1, emailForQuery);
//            ResultSet results = statement.executeQuery();
//            results.next();
//            String emailDB = results.getString("USERNAME");
//            if (emailDB.equals(email)){
//                connection.close();
//                return "Username already exists";
//            }
            sql_query = "INSERT INTO ISTOS.USERS (USERNAME, PASS) "+ "VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                connection.close();
                return "SUCCESS";
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return "Sign-Up failed...!";
    }
}
