package com.example.finalpracticehard.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalpracticehard.model.Student;

import java.util.List;

@Dao
public interface StudentDAO {
    //CRUD:
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Student> student);

    @Query("SELECT * FROM students")
    List<Student> getAll();

//    @Query("SELECT * FROM students WHERE userid = :userid")
//    Student getById(String userid);
//
//    @Query("SELECT * FROM students WHERE name = :name")
//    Student getByName(String name);
//
//    @Query ("DELETE FROM students")
//    Boolean deleteAll();
//
//    @Query ("DELETE FROM students WHERE userid = :userid")
//    Boolean deleteById(String userid);
//
//    @Query ("DELETE FROM students WHERE name = :name")
//    Boolean deleteByName(String name);
}
