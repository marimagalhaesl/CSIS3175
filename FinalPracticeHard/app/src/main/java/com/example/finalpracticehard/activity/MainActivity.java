package com.example.finalpracticehard.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.finalpracticehard.R;
import com.example.finalpracticehard.dao.StudentDAO;
import com.example.finalpracticehard.dao.TaskDAO;
import com.example.finalpracticehard.database.AppDatabase;
import com.example.finalpracticehard.model.Student;
import com.example.finalpracticehard.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList = new ArrayList<>();
    List<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = ReadStudentCSVFile();
        taskList = ReadTaskCSVFile();

        Log.d("CSV_READING", "Student list size: " + (studentList.size()+1) + "\tTask list size: " + (taskList.size()+1));

        //init the db:
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "TodoList.db").build();
        StudentDAO studentDAO = db.studentDAO();
        TaskDAO taskDAO = db.taskDAO();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                //insert all records from students and tasks:
                studentDAO.insertAll(studentList);
                taskDAO.insertAll(taskList);

            } catch (Exception exception) {
                Log.d("DEBUG_DB", "DB Exception Occurred" + exception.getMessage());
            }
        });
    }








    //Read the CSV file and populate the lists accordingly:
    private List<Student> ReadStudentCSVFile() {
        //create the input stream and the buffer:
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {

            String line = bufferedReader.readLine();

            while ( (line = bufferedReader.readLine()) != null) {
                String[] token = line.split(",");
                Student student = new Student(token[0], token[1]);
                studentList.add(student);
            }

        } catch (IOException ioException) {
            throw new RuntimeException("Error reading the student csv file: " + ioException.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException ioException) {
                throw new RuntimeException("Error closing the student csv file " + ioException.getMessage());
            }
        }
        return studentList;
    }

    private List<Task> ReadTaskCSVFile() {
        //create the input stream and the buffer:
        InputStream inputStream = getResources().openRawResource(R.raw.tasks);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {

            String line = bufferedReader.readLine();

            while ( (line = bufferedReader.readLine()) != null) {
                String[] token = line.split(",");
                Task task = new Task(token[0], token[1], token[2], Boolean.parseBoolean(token[3]));
                taskList.add(task);
            }

        } catch (IOException ioException) {
            throw new RuntimeException("Error reading the student csv file: " + ioException.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException ioException) {
                throw new RuntimeException("Error closing the student csv file " + ioException.getMessage());
            }
        }
        return taskList;
    }
}