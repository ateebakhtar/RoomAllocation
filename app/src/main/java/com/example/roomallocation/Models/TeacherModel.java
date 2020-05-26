package com.example.roomallocation.Models;

public class TeacherModel
{
    String section;
    String[] courses;
    String semester;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public TeacherModel(String section, String[] courses, String semester, String name) {
        this.section = section;
        this.courses = courses;
        this.semester = semester;
        this.name = name;
    }

    public TeacherModel(String section, String[] courses, String semester) {
        this.section = section;
        this.courses = courses;
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }



}
