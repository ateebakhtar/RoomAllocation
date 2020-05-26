package com.example.roomallocation.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.roomallocation.Models.Data;
import com.example.roomallocation.R;
import com.example.roomallocation.Student.StudentList;
import com.example.roomallocation.Teacher.TeacherList;

public class CustomDialogClass extends Dialog implements android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes;

    public Spinner day;
    public Spinner section;
    public Spinner batch;

    private String[] sections = {"All","A","B","C","D","E","F"};
    private String[] batches = {"All","Batch19","Batch18","Batch17","Batch16"};
    private String[] days = {"All","1","2","3","4","5","6","7","8"};
    private Context context;

    int index = 1;

    public CustomDialogClass(Activity a, Context context,int index) {
        super(a);
        this.context = context;
        this.index = index;
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box);
        yes = (Button) findViewById(R.id.button7);

        day = findViewById(R.id.day);
        section = findViewById(R.id.section);
        batch = findViewById(R.id.batch);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, sections);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, days);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, batches);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        batch.setAdapter(adapter2);

        yes.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {

        Data.Batchfilter = batch.getSelectedItem().toString();
        Data.dayfilter = day.getSelectedItem().toString();
        Data.Sectionfilter = section.getSelectedItem().toString();

        if(index == 1)
        {
            Intent i = new Intent(context, StudentList.class);
            context.startActivity(i);
        }
        else
        {
            Intent i = new Intent(context, TeacherList.class);
            context.startActivity(i);
        }

        dismiss();
    }
}