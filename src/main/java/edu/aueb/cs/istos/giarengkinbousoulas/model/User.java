package edu.aueb.cs.istos.giarengkinbousoulas.model;

public class User {

    private String username;
    private String password;

    public User()  {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
