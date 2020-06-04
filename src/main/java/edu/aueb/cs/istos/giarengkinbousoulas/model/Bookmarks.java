package edu.aueb.cs.istos.giarengkinbousoulas.model;

import java.util.ArrayList;
import java.util.List;

public class Bookmarks {

    //Class Variables
    private int userID;
    private List<String> myBookmarks = new ArrayList<>();

    //Constructors
    public Bookmarks(){

    }

    public Bookmarks(int userID, List<String> myBookmarks) {

        this.userID = userID;
        this.myBookmarks = myBookmarks;
    }

    //Setter and Getters
    public List<String> getMyBookmarks() {
        return myBookmarks;
    }

    public void setMyBookmarks(List<String> myBookmarks) {
        this.myBookmarks = myBookmarks;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //New Methods
    public void addToList(String input){
        myBookmarks.add(input);
    }

}
