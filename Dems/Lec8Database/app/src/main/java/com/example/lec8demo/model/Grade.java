package com.example.lec8demo.model;

public class Grade {

    private String CourseId;
    private String StudId;
    private String StudGrade;

    public Grade(String courseId, String studId, String studGrade) {
        CourseId = courseId;
        StudId = studId;
        StudGrade = studGrade;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getStudId() {
        return StudId;
    }

    public void setStudId(String studId) {
        StudId = studId;
    }

    public String getStudGrade() {
        return StudGrade;
    }

    public void setStudGrade(String studGrade) {
        StudGrade = studGrade;
    }
}
