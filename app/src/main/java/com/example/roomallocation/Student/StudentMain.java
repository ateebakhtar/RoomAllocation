package com.example.roomallocation.Student;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roomallocation.R;
import com.example.roomallocation.Teacher.TeacherMain;

public class StudentMain extends AppCompatActivity
{

    Spinner semester;
    Spinner section;
    ListView courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        section = findViewById(R.id.section);
        semester = findViewById(R.id.semester);
        courses = findViewById(R.id.courselist);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.section));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.semester));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter1);

        final String[] x = getResources().getStringArray(R.array.s1);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,x);
        courses.setAdapter(adapter2);

        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        ArrayAdapter adapter2 = new ArrayAdapter<String>(StudentMain.this,android.R.layout.simple_list_item_1,x);
                        courses.setAdapter(adapter2);
                        break;
                    case 1:
                        String[] x1 = getResources().getStringArray(R.array.s2);
                        ArrayAdapter adapter3 = new ArrayAdapter<String>(StudentMain.this,android.R.layout.simple_list_item_1,x1);
                        courses.setAdapter(adapter3);
                        break;
                    case 2:
                        String[] x2 = getResources().getStringArray(R.array.s3);
                        ArrayAdapter adapter4 = new ArrayAdapter<String>(StudentMain.this,android.R.layout.simple_list_item_1,x2);
                        courses.setAdapter(adapter4);
                        break;
                    case 3:
                        String[] x3 = getResources().getStringArray(R.array.s4);
                        ArrayAdapter adapter5 = new ArrayAdapter<String>(StudentMain.this,android.R.layout.simple_list_item_1,x3);
                        courses.setAdapter(adapter5);
                        break;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
    }

    public void openT(View view)
    {
        Intent i = new Intent(this, StudentList.class);
        startActivity(i);
    }


}
