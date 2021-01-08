package com.example.shiftplanner.Manager;

public class Login
{
    private String ID;
    private String idikotita;
    private String username;
    private String password;

    public Login(String ID, String idikotita, String username, String password) {
        this.ID = ID;
        this.idikotita = idikotita;
        this.username = username;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getidikotita() {
        return idikotita;
    }

    public void setidikotita(String idikotita) {
        this.idikotita = idikotita;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
