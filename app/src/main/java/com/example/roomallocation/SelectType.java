package com.example.roomallocation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomallocation.Connections.FetchClassConnection;
import com.example.roomallocation.Connections.GetInstructorConnection;
import com.example.roomallocation.Student.StudentList;
import com.example.roomallocation.Student.StudentMain;
import com.example.roomallocation.Teacher.TeacherList;
import com.example.roomallocation.Teacher.TeacherMain;

public class SelectType extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
        new FetchClassConnection(this).execute();
        new GetInstructorConnection(this).execute();
    }

    public void openT(View view)
    {
        Intent i = new Intent(this, TeacherList.class);
        startActivity(i);
    }

    public void openS(View view)
    {
        Intent i = new Intent(this, StudentList.class);
        startActivity(i);
    }
}
