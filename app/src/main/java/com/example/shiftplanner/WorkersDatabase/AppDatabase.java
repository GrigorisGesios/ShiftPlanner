package com.example.shiftplanner.WorkersDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Worker.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WorkerDao userDao();
}