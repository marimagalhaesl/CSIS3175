package com.example.lec8demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.lec8demo.model.Grade;
import com.example.lec8demo.adapters.GradeAdapter;
import com.example.lec8demo.R;
import com.example.lec8demo.model.Student;
import com.example.lec8demo.adapters.StudentAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> MyStudents = ReadCSVStudents();
        Log.d("DBDEMO", "Total " + MyStudents.size() + " Added to the list");

        ListView listViewStudents = findViewById(R.id.listViewStudents);

        listViewStudents.setAdapter(new StudentAdapter(MyStudents));

        List<Grade> MyGrades = ReadCSVGrades();
        Log.d("DBDEMO", "Total " + MyGrades.size() + " grades added to the list");

        ListView listViewGrades = findViewById(R.id.listViewGrades);
        listViewGrades.setAdapter(new GradeAdapter(MyGrades));
    }

    private List<Student> ReadCSVStudents() {
        List<Student> studentsList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
           String csvStudentLine = reader.readLine(); //header line is read out before entering the while loop

            //String csvStudentLine; //not taking the header out

            while ((csvStudentLine = reader.readLine()) != null) {
                String[] eachStudLine = csvStudentLine.split(",");
                Student eachStudent = new Student(eachStudLine[0], eachStudLine[1], eachStudLine[2]);
                studentsList.add(eachStudent);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error reading csv file " + ex);
        } finally {
            try{
                inputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException("Error closing input stream " + ex);
            }
        }

        return studentsList;
    }

    private List<Grade> ReadCSVGrades() {
        List<Grade> GradesList = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.grades);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvGradeLine = reader.readLine();
            while((csvGradeLine = reader.readLine()) != null) {
                String[] eachGradeLine = csvGradeLine.split(",");
                //double grade = Double.parseDouble(eachGradeLine[2]);
                Grade eachGrade = new Grade(eachGradeLine[0], eachGradeLine[1], eachGradeLine[2]);
                GradesList.add(eachGrade);
            }

        } catch (IOException ex) {
            throw new RuntimeException("Error reading CSV file " + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException("Error closing stream..." + ex);
            }

        }



        return GradesList;
    }
}