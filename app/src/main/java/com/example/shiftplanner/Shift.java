package com.example.shiftplanner;

public class Shift {

    private String shiftTime;
    private String shiftStaff;

    public Shift(String shiftTime, String shiftStaff) {
        this.shiftTime = shiftTime;
        this.shiftStaff = shiftStaff;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getShiftStaff() {
        return shiftStaff;
    }

    public void setShiftStaff(String shiftStaff) {
        this.shiftStaff = shiftStaff;
    }
}
