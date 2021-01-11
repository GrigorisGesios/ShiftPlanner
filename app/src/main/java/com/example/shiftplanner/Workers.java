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
    private boolean isInShift = false;

    public Workers(String firstName, String lastName, String workersID, String workersProf, String oxiV, String VardiaO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workersID = workersID;
        this.WorkersProf = workersProf;
        this.MeraO = oxiV;
        this.VardiaO = VardiaO;
    }

    public Workers() {

    }

    public Workers(String firstname, String lastname, String id, String idikotita,String Vardiap,String mera0,String vardia0) {
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

    public boolean isInShift() {
        return isInShift;
    }

    public void setInShift(boolean inShift) {
        isInShift = inShift;
    }

    public String getVardiaO() { return VardiaO; }

    public void setVardiaO(String vardiaO) { this.VardiaO = vardiaO; }

}
