package com.example.roomallocation.Interfaces;

import com.example.roomallocation.Models.TimetableData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TimetableInterface
{
    @GET("api/timetable/FetchTimetable")
    Call<ArrayList<TimetableData>> FetchTimetable();

    @GET("api/timetable/reallocateclassroom")
    Call<Boolean> reallocateclassroom(@Query("course") String course, @Query("section") String Section, @Query("day") int day);

    @GET("api/timetable/extraclass")
    Call<TimetableData> extraclass(@Query("course") String course, @Query("section") String Section, @Query("day") int day, @Query("instructor") String instructor);

    @GET("api/timetable/GetInstructor")
    Call<ArrayList<String>> GetInstructor();
}
