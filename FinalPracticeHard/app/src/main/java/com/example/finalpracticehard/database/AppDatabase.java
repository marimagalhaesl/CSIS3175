package com.example.finalpracticehard.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalpracticehard.dao.StudentDAO;
import com.example.finalpracticehard.dao.TaskDAO;
import com.example.finalpracticehard.model.Student;
import com.example.finalpracticehard.model.Task;

@Database(entities = {Student.class, Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
    public abstract TaskDAO taskDAO();
}
