package edu.aueb.cs.istos.giarengkinbousoulas.model;

import java.util.ArrayList;
import java.util.List;

public class Bookmarks {

    //Class Variables
    private int userID;
    private List<Bookmark> myBookmarks = new ArrayList<Bookmark>();

    //Constructors
    public Bookmarks(){

    }

    public Bookmarks(int userID, List<Bookmark> myBookmarks) {

        this.userID = userID;
        this.myBookmarks = myBookmarks;
    }

    //Setter and Getters
    public List<Bookmark> getMyBookmarks() {
        return myBookmarks;
    }

    public void setMyBookmarks(List<Bookmark> myBookmarks) {
        this.myBookmarks = myBookmarks;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //New Methods
    public void addToList(Bookmark input){
        myBookmarks.add(input);
    }

}
