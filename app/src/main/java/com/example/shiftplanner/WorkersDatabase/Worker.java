package com.example.shiftplanner.WorkersDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Worker {

        @PrimaryKey
        public int workersID;

        @ColumnInfo(name = "first_name")
        public String firstName;

        @ColumnInfo(name = "last_name")
        public String lastName;

        @ColumnInfo(name = "WorkersProf")
        public String major;

        public Worker(int id, String firstName, String lastName, String major) {
                this.workersID=id;
                this.firstName=firstName;
                this.lastName=lastName;
                this.major=major;
        }

        public int getId() {
                return workersID;
        }

        public void setId(int id) {
                this.workersID = id;
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

        public String getMajor() {
                return major;
        }

        public void setMajor(String major) {
                this.major = major;
        }
}


