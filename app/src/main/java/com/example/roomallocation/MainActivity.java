package com.example.roomallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.roomallocation.Connections.FetchClassConnection;
import com.example.roomallocation.Student.StudentMain;
import com.example.roomallocation.Teacher.TeacherMain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = new Intent(this, SelectType.class);
        startActivity(i);

    }
}
