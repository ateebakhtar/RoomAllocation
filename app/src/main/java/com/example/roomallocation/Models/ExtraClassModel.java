package com.example.roomallocation.Models;

public class ExtraClassModel
{
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    String course;
    String semester;
    String section;
    String timeslot;

    public ExtraClassModel(String course, String semester, String section, String timeslot) {
        this.course = course;
        this.semester = semester;
        this.section = section;
        this.timeslot = timeslot;
    }
}
