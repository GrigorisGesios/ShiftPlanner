package com.example.shiftplanner;

public class Workers
{
    private String firstName;
    private String lastName;
    private String ID;
    private String WorkersProf;

    public Workers(String firstName, String lastName, String ID, String workersProf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.WorkersProf = workersProf;
    }

    public Workers() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWorkersProf() {
        return WorkersProf;
    }

    public void setWorkersProf(String workersProf) {
        WorkersProf = workersProf;
    }
}
