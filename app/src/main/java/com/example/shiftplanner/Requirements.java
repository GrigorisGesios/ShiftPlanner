package com.example.shiftplanner;

public class Requirements
{

    private String requirementsID;
    private String preference;
    private String vardiaP;
    private String oxivar;
    private String vardiaO;

    public Requirements(String requirementsID, String preference, String vardiaP, String oxivar, String vardiaO) {
        this.requirementsID = requirementsID;
        this.preference = preference;
        this.vardiaP = vardiaP;
        this.oxivar = oxivar;
        this.vardiaO = vardiaO;
    }

    public String getRequirementsID() {
        return requirementsID;
    }

    public void setRequirementsID(String requirementsID) {
        this.requirementsID = requirementsID;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getVardiaP() {
        return vardiaP;
    }

    public void setVardiaP(String vardiaP) {
        this.vardiaP = vardiaP;
    }

    public String getOxivar() {
        return oxivar;
    }

    public void setOxivar(String oxivar) {
        this.oxivar = oxivar;
    }

    public String getVardiaO() {
        return vardiaO;
    }

    public void setVardiaO(String vardiaO) {
        this.vardiaO = vardiaO;
    }
}
