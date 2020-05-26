package com.example.roomallocation.Teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomallocation.Connections.ExtraClassConnection;
import com.example.roomallocation.Connections.FetchClassConnection;
import com.example.roomallocation.Connections.ReallocateConnection;
import com.example.roomallocation.Models.Data;
import com.example.roomallocation.R;

public class ExtraClass extends AppCompatActivity
{
    Spinner semester;
    Spinner section;
    ListView courses;
    Spinner timeslot;
    String courseq;
    Spinner teachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_class);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        timeslot = findViewById(R.id.timeslot);
        section = findViewById(R.id.section);
        semester = findViewById(R.id.semester);
        courses = findViewById(R.id.listview);
        teachers = findViewById(R.id.instructor);



        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Data.taechers);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teachers.setAdapter(adapter5);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.section));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.semester));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter1);

        String[] day = {"1","2","3","4","5"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, day);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeslot.setAdapter(adapter3);

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
                        ArrayAdapter adapter2 = new ArrayAdapter<String>(ExtraClass.this,android.R.layout.simple_list_item_1,x);
                        courses.setAdapter(adapter2);
                        break;
                    case 1:
                        String[] x1 = getResources().getStringArray(R.array.s2);
                        ArrayAdapter adapter3 = new ArrayAdapter<String>(ExtraClass.this,android.R.layout.simple_list_item_1,x1);
                        courses.setAdapter(adapter3);
                        break;
                    case 2:
                        String[] x2 = getResources().getStringArray(R.array.s3);
                        ArrayAdapter adapter4 = new ArrayAdapter<String>(ExtraClass.this,android.R.layout.simple_list_item_1,x2);
                        courses.setAdapter(adapter4);
                        break;
                    case 3:
                        String[] x3 = getResources().getStringArray(R.array.s4);
                        ArrayAdapter adapter5 = new ArrayAdapter<String>(ExtraClass.this,android.R.layout.simple_list_item_1,x3);
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

        courses.setClickable(true);
        courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = courses.getItemAtPosition(position);
                String str=(String)o;//As you are using Default String Adapter
                courseq = str;
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void extraclaases(View view)
    {


        if(courseq.equals("Empty"))
        {
            Toast.makeText(this, "Please select a course", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sec = section.getSelectedItem().toString();
            String day = timeslot.getSelectedItem().toString();
            String ins = teachers.getSelectedItem().toString();
            new ExtraClassConnection(this,courseq,sec,Integer.parseInt(day),ins).execute();
            Intent i = new Intent(this,TeacherList.class);
            new FetchClassConnection(this).execute();
            startActivity(i);
        }
    }
}
