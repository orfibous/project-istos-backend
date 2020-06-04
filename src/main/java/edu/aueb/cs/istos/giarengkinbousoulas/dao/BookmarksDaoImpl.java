package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmarks;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import java.sql.*;
import java.util.List;

public class BookmarksDaoImpl {
    public List<String> fillBookmarksList(int userID) throws SQLException {
        Bookmarks bookmarks = new Bookmarks();

        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;

        String movieID = "";

        try {
            connection = DatabaseHandler.createConnection();
            statement = connection.createStatement();
            String sql = String.format("SELECT MOVIE_ID FROM ISTOS.USER_LIKES WHERE USER_ID = %d", bookmarks.getUserID());
            results = statement.executeQuery(sql);
            System.out.println(results);
            while(results.next()){
                movieID = results.getString("MOVIE_ID");
                bookmarks.addToList(movieID);
            }
        }
        catch (SQLException SQLE){
            SQLE.printStackTrace();
        }
        connection.close();
        return bookmarks.getMyBookmarks();
    }
}
