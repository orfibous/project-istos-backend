package edu.aueb.cs.istos.giarengkinbousoulas.model;

public class User {

    private int id;
    private String email;
    private String password;

    public User()  {

    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return id;
    }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setID(int id) {this.id = id;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {
        this.password = password;
    }
}
