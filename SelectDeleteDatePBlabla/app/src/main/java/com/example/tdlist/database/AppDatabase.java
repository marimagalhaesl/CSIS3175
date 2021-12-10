package com.example.tdlist.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tdlist.TaskDAO;
import com.example.tdlist.model.Task;

@Database(entities = {Task.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDAO taskDAO();
}
