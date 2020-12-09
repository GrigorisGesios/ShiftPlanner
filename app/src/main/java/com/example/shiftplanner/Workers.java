package com.example.shiftplanner;

public class Workers
{
    private String firstName;
    private String lastName;
    private String workersID;
    private String WorkersProf;
    private String VardiaP;
    private String MeraO;
    private String VardiaO;
    private String hoursworked;


    public Workers(String firstName, String lastName, String workersID, String workersProf,
                   String VardiaP, String oxiV, String VardiaO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workersID = workersID;
        this.WorkersProf = workersProf;
        this.VardiaP = VardiaP;
        this.MeraO = oxiV;
        this.VardiaO = VardiaO;
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

    public void setWorkersProf(String workersProf) { this.WorkersProf = workersProf; }

    public String getVardiaP() { return VardiaP; }

    public void setVardiaP(String vardiaP) { this.VardiaP = vardiaP; }

    public String getMeraO() { return MeraO; }

    public void setMeraV(String oxiV) { this.MeraO = oxiV; }

    public String getVardiaO() { return VardiaO; }

    public void setVardiaO(String vardiaO) { this.VardiaO = vardiaO; }
}
