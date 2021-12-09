package com.example.finalpracticehard.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {

    @PrimaryKey
    @ColumnInfo(name = "userid")
    @NonNull
    private String userid;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    public Student(@NonNull String userid, @NonNull String name) {
        this.userid = userid;
        this.name = name;
    }

    @NonNull
    public String getUserid() {
        return userid;
    }

    public void setUserid(@NonNull String userid) {
        this.userid = userid;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
