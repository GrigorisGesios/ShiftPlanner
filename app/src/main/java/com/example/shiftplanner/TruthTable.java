package com.example.shiftplanner;

public class TruthTable
{
    private Workers worker;
    private int totalhoursworked;
    private boolean insertedin;

    public TruthTable(Workers worker) {
        this.worker = worker;
        this.totalhoursworked = 0;
        this.insertedin = false;
    }

    public int addToTotalHoursWorked(int hoursadded)
    {
        totalhoursworked += hoursadded;
        return totalhoursworked;
    }
    public Workers getWorker() {
        return worker;
    }

    public void setWorker(Workers worker) {
        this.worker = worker;
    }

    public int getTotalhoursworked() {
        return totalhoursworked;
    }

    public void setTotalhoursworked(int totalhoursworked) {
        this.totalhoursworked = totalhoursworked;
    }

    public boolean isInsertedin() {
        return insertedin;
    }

    public void setInsertedin(boolean insertedin) {
        this.insertedin = insertedin;
    }
}
