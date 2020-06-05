package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import edu.aueb.cs.istos.giarengkinbousoulas.configuration.Globals;
import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmark;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmarks;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

public class BookmarksDaoImpl {
    //Fill a Bookmarks List from database
    public List<Bookmark> fillBookmarksList(int userID) throws SQLException {
        Bookmarks bookmarks = new Bookmarks();

        Connection connection = null;
        PreparedStatement statement;
        ResultSet results;

        String movieID;

        try {
            //Sen Query to database
            connection = DatabaseHandler.createConnection();
            //Get all the bookmarks matching the logged-in user's ID
            statement = connection.prepareStatement("SELECT MOVIE_ID FROM ISTOS.USER_LIKES WHERE USER_ID = ?");
            statement.setInt(1, userID);
            results = statement.executeQuery();
            //Add Bookmarks to List
            while(results.next()){
                movieID = results.getString("MOVIE_ID");
                Bookmark bookmark = new Bookmark(movieID);
                bookmarks.addToList(bookmark);
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return bookmarks.getMyBookmarks();
    }

    public String removeBookmark(int userID, String movieID) throws SQLException {
        Bookmarks bookmarks = new Bookmarks();

        Connection connection = null;
        PreparedStatement statement;
        ResultSet results;

        try {
            //Sen Query to database
            connection = DatabaseHandler.createConnection();
            //Get all the bookmarks matching the logged-in user's ID
            statement = connection.prepareStatement("DELETE FROM ISTOS.USER_LIKES " + "WHERE USER_ID = ? AND MOVIE_ID = ?");
            statement.setInt(1, userID);
            statement.setString(2, movieID);

            int i = statement.executeUpdate();
            if (i != 0) {
                connection.close();
                return movieID + " removed from database";
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return movieID + " Failed to remove from database";
    }

    public String addBookmark(int userID, String movieID) throws SQLException {
        Bookmarks bookmarks = new Bookmarks();

        Connection connection = null;
        PreparedStatement statement;
        ResultSet results;

        try {
            //Sen Query to database
            connection = DatabaseHandler.createConnection();
            //Get all the bookmarks matching the logged-in user's ID
            statement = connection.prepareStatement("INSERT INTO ISTOS.USER_LIKES (USER_ID, MOVIE_ID)" + "VALUES (?,?)");
            statement.setInt(1, userID);
            statement.setString(2, movieID);

            int i = statement.executeUpdate();
            if (i != 0) {
                connection.close();
                return movieID + " added to database";
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return movieID + " Failed to add to database";
    }
}
