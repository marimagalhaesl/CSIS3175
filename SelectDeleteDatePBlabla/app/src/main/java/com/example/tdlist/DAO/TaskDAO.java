package com.example.tdlist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tdlist.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {

    //SELECT:

    @Query("SELECT * FROM tasks")
    List<Task> getAll();

    //INSERT:

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Task task);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Task> tasks);


    //DELETE:

    @Query("DELETE FROM tasks WHERE id =:id")
    void deleteById(String id);

    @Query("DELETE FROM tasks")
    void deleteAll();
}
