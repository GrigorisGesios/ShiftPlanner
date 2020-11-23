package com.example.shiftplanner;

public class Employers
{
    private String firstName;
    private String lastName;
    private String employerID;
    private String employerProf;

    public Employers(String firstName, String lastName, String employerID, String employerProf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employerID = employerID;
        this.employerProf = employerProf;
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

    public String getEmployerID() {
        return employerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public String getEmployerProff() {
        return employerProf;
    }

    public void setEmployerProff(String employerProff) {
        this.employerProf = employerProf;
    }
}
