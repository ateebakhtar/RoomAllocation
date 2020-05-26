package com.example.roomallocation.Student;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomallocation.Adapter.CustomDialogClass;
import com.example.roomallocation.Adapter.TimetableAdapter;
import com.example.roomallocation.Models.Data;
import com.example.roomallocation.Models.TimetableModel;
import com.example.roomallocation.R;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity
{
    RecyclerView studentlist;
    TimetableAdapter adapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        studentlist = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        studentlist.setLayoutManager(mLayoutManager);

        ArrayList<TimetableModel> x = new ArrayList<>();



        for(int i=0;i<Data.ttd.size();i++)
        {
            if(Data.Sectionfilter.equals("All") && Data.dayfilter.equals("All") && Data.Batchfilter.equals("All"))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals("All") && Data.dayfilter.equals("All") && Data.Batchfilter.equals(Data.ttd.get(i).batch))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals("All") && Data.dayfilter.equals(""+Data.ttd.get(i).day) && Data.Batchfilter.equals("All"))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals(Data.ttd.get(i).getSection()) && Data.dayfilter.equals("All") && Data.Batchfilter.equals("All"))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals("All") && Data.dayfilter.equals(""+Data.ttd.get(i).day) && Data.Batchfilter.equals(Data.ttd.get(i).batch))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals(Data.ttd.get(i).section) && Data.dayfilter.equals("All") && Data.Batchfilter.equals(Data.ttd.get(i).batch))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals(Data.ttd.get(i).section) && Data.dayfilter.equals(""+Data.ttd.get(i).day) && Data.Batchfilter.equals("All"))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));
            }
            else if(Data.Sectionfilter.equals(Data.ttd.get(i).section) && Data.dayfilter.equals(""+Data.ttd.get(i).day) && Data.Batchfilter.equals(Data.ttd.get(i).batch))
            {
                x.add(new TimetableModel(""+Data.ttd.get(i).day,""+Data.ttd.get(i).timeslot,Data.ttd.get(i).course,Data.ttd.get(i).room,Data.ttd.get(i).empname,Data.ttd.get(i).section,Data.ttd.get(i).batch));

            }

        }

        adapter = new TimetableAdapter(x,0);
        studentlist.setAdapter(adapter);
    }

    public void filterrows(View view)
    {
        CustomDialogClass cdd=new CustomDialogClass(this,this,1);
        cdd.show();
    }
}
