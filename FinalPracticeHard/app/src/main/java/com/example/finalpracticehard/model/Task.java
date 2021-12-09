package com.example.finalpracticehard.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks", foreignKeys = {@ForeignKey(entity = Student.class, parentColumns = "userid", childColumns = "userid", onDelete = ForeignKey.CASCADE)})
public class Task {

    @PrimaryKey
    @ColumnInfo(name = "taskid")
    @NonNull
    private String taskid;

    @ColumnInfo(name = "userid")
    @NonNull
    private String userId;

    @ColumnInfo (name = "description")
    private String description;

    @ColumnInfo (name = "isCompleted", defaultValue = "false")
    private Boolean isCompleted;

    public Task(@NonNull String taskid, @NonNull String userId, String description, Boolean isCompleted) {
        this.taskid = taskid;
        this.userId = userId;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    @NonNull
    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(@NonNull String taskid) {
        this.taskid = taskid;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
