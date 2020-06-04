package edu.aueb.cs.istos.giarengkinbousoulas.configuration;

import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmarks;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;

public class Globals {
    //Unique active User
    public static User activeUser = new User();
    //Unique bookmarks of the active user
    public static Bookmarks activeUserBookmarks = new Bookmarks();
}
