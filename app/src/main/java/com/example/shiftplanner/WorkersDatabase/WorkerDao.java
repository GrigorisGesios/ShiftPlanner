package com.example.shiftplanner.WorkersDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface WorkerDao {
        @Query("SELECT * FROM worker")
        List<Worker> getAll();

        @Update
        void updateAll(Worker workers);

        @Insert
        void insertAll(Worker workers);

        @Delete
        void delete(Worker workers);

        @Query("SELECT * FROM Worker ORDER BY workersID")
        List<Worker> loadAllWorkers();

        @Query("SELECT * FROM Worker WHERE workersID = :id")
        Worker loadWorkersById(int id);
}
