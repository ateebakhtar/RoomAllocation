package com.example.roomallocation.Models;

public class TimetableModel
{
    public TimetableModel(String day, String timeslot, String course, String room, String intructor,String section,String batch) {
        this.day = day;
        this.timeslot = timeslot;
        this.course = course;
        this.room = room;
        this.intructor = intructor;
        this.Section = section;
        this.batch = batch;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    String batch;
    String Section;
    String day;
    String timeslot;
    String course;
    String room;
    String intructor;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getIntructor() {
        return intructor;
    }

    public void setIntructor(String intructor) {
        this.intructor = intructor;
    }
}
