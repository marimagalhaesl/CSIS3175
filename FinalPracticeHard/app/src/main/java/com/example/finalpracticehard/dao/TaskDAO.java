package com.example.finalpracticehard.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalpracticehard.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    //CRUD:
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Task> tasks);

    @Query("SELECT * FROM tasks")
    List<Task> getAll();

//    @Query("SELECT * FROM tasks WHERE taskid = :taskid")
//    Student getById(String taskid);
//
//    @Query("SELECT * FROM tasks WHERE userid = :userid")
//    Student getByUserId(String userid);
//
//    @Query ("DELETE FROM tasks")
//    Boolean deleteAll();
//
//    @Query ("DELETE FROM students WHERE name = :taskid")
//    Boolean deleteById(String taskid);
//
//    @Query ("DELETE FROM tasks WHERE userid = :userid")
//    Boolean deleteByUserId(String userid);

}
