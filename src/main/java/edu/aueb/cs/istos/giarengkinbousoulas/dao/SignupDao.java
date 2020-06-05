package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import com.mysql.cj.protocol.Resultset;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.*;

@SuppressWarnings("ALL")
public class SignupDao {
    public String registerUser(User registeredUser) throws SQLException {
        int user_id = registeredUser.getID();
        String email = registeredUser.getEmail();
        String password = registeredUser.getPassword();

        Connection connection = null;
        PreparedStatement preparedStatement;

        int userID_counter;
        int userID;
        String emailDB = "";
        String passwordDB = "";
        try {
            connection = DatabaseHandler.createConnection();
            String sql_query;
            Statement id_statement = connection.createStatement();
            ResultSet id_results = id_statement.executeQuery("SELECT USER_ID FROM ISTOS.USERS ORDER BY USER_ID DESC LIMIT 1");
            if(id_results.next()){
                userID_counter = id_results.getInt("USER_ID");
            }
            else {
                userID_counter = -1;
            }
            System.out.println(userID_counter);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ISTOS.USERS WHERE USERNAME = ?;");
            statement.setString(1, email);
            ResultSet results = statement.executeQuery();
            while(results.next()){
                userID = results.getInt("USER_ID");
                emailDB = results.getString("USERNAME");
                passwordDB = results.getString("PASS");
                System.out.println(email + " " + emailDB);
                System.out.println(password + " " + passwordDB);
                if (email.equals(emailDB) && password.equals(passwordDB)){
                    connection.close();
                    return "User already exists!";
                }
            }
            sql_query = "INSERT INTO ISTOS.USERS (USER_ID, USERNAME, PASS) "+ "VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setInt(1, userID_counter + 1);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

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
