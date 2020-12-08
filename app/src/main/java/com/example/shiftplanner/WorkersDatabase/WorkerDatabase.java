package com.example.shiftplanner.WorkersDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Worker.class,exportSchema = false,version = 1)

public abstract class WorkerDatabase extends RoomDatabase {
    private static final String DB_NAME = "Worker_db";
    private static WorkerDatabase instance ;

    public static synchronized WorkerDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), WorkerDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();

        }
        return instance;
    }
    public abstract WorkerDao workersDao();

}
