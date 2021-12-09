package com.example.lec8demo.model;

public class Student {

    private String StudentId;
    private String StudentName;
    private String StudentDept;

    public Student(String studentId, String studentName, String studentDept) {
        StudentId = studentId;
        StudentName = studentName;
        StudentDept = studentDept;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentDept() {
        return StudentDept;
    }

    public void setStudentDept(String studentDept) {
        StudentDept = studentDept;
    }
}
