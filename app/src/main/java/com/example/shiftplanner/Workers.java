package com.example.shiftplanner;

public class Workers
{
    private String firstName;
    private String lastName;
    private String workersID;
    private String WorkersProf;

    public Workers(String firstName, String lastName, String workersID, String workersProf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workersID = workersID;
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

    public String getWorkersID() {
        return workersID;
    }

    public void setWorkersID(String workersID) {
        this.workersID = workersID;
    }

    public String getWorkersProf() {
        return WorkersProf;
    }

    public void setWorkersProf(String workersProf) {
        WorkersProf = workersProf;
    }
}
