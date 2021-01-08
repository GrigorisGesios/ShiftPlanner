package com.example.shiftplanner;

public class Restrictions
{
    private String numvard,mornvard,noonvard,nightvard,hoursvard,hoursweek,adeiamax;

    public Restrictions(String numvard, String mornvard, String noonvard, String nightvard, String hoursvard, String hoursweek, String adeiamax) {
        this.numvard = numvard;
        this.mornvard = mornvard;
        this.noonvard = noonvard;
        this.nightvard = nightvard;
        this.hoursvard = hoursvard;
        this.hoursweek = hoursweek;
        this.adeiamax = adeiamax;
    }

    public Restrictions() {

    }

    public String getNumvard() {
        return numvard;
    }

    public void setNumvard(String numvard) {
        this.numvard = numvard;
    }

    public String getMornvard() {
        return mornvard;
    }

    public void setMornvard(String mornvard) {
        this.mornvard = mornvard;
    }

    public String getNoonvard() {
        return noonvard;
    }

    public void setNoonvard(String noonvard) {
        this.noonvard = noonvard;
    }

    public String getNightvard() {
        return nightvard;
    }

    public void setNightvard(String nightvard) {
        this.nightvard = nightvard;
    }

    public String getHoursvard() {
        return hoursvard;
    }

    public void setHoursvard(String hoursvard) {
        this.hoursvard = hoursvard;
    }

    public String getHoursweek() {
        return hoursweek;
    }

    public void setHoursweek(String hoursweek) {
        this.hoursweek = hoursweek;
    }

    public String getAdeiamax() {
        return adeiamax;
    }

    public void setAdeiamax(String adeiamax) {
        this.adeiamax = adeiamax;
    }
}
