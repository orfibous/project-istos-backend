package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmark;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmarks;
import edu.aueb.cs.istos.giarengkinbousoulas.utils.DatabaseHandler;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

public class BookmarksDaoImpl {
    public List<Bookmark> fillBookmarksList(int userID) throws SQLException {
        Bookmarks bookmarks = new Bookmarks();

        Connection connection = null;
        Statement statement;
        ResultSet results;

        String movieID;

        try {
            connection = DatabaseHandler.createConnection();
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT MOVIE_ID FROM ISTOS.USER_LIKES WHERE USER_ID = ?");
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
}
