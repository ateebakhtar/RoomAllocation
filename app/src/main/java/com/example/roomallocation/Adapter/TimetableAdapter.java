package com.example.roomallocation.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomallocation.MainActivity;
import com.example.roomallocation.Models.TimetableModel;
import com.example.roomallocation.R;

import java.util.ArrayList;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ExampleViewHolder>
{
    public ArrayList<TimetableModel> timetablelist;
    public int status = 0;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView timeslot;
        public TextView course;
        public TextView instructor;
        public TextView day;
        public TextView room;
        public TextView section;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            timeslot = itemView.findViewById(R.id.timelsot);
            course = itemView.findViewById(R.id.course);
            day = itemView.findViewById(R.id.day);
            section = itemView.findViewById(R.id.section);
            room = itemView.findViewById(R.id.room);
            instructor = itemView.findViewById(R.id.instructor);
        }
    }

    public TimetableAdapter(ArrayList<TimetableModel> exampleList,int status)
    {
        this.status = status;
        timetablelist = exampleList;
    }

    @Override
    public TimetableAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_layoiut,parent,false);
        TimetableAdapter.ExampleViewHolder evh=new TimetableAdapter.ExampleViewHolder(v);
        return evh;

    }



    @Override
    public void onBindViewHolder(TimetableAdapter.ExampleViewHolder holder, int position) {
        final TimetableModel currentItem = timetablelist.get(position);

        holder.room.setText(currentItem.getRoom().toString());
        holder.day.setText(currentItem.getDay());
        holder.instructor.setText(currentItem.getIntructor().toString());
        holder.course.setText(currentItem.getCourse().toString());
        holder.section.setText(currentItem.getSection().toString());

        if(currentItem.getTimeslot().equals("1"))
        {
            holder.timeslot.setImageResource(R.drawable.one);
        }
        else if(currentItem.getTimeslot().equals("2"))
        {
            holder.timeslot.setImageResource(R.drawable.two);
        }
        else if(currentItem.getTimeslot().equals("3"))
        {
            holder.timeslot.setImageResource(R.drawable.three);
        }
        else if(currentItem.getTimeslot().equals("4"))
        {
            holder.timeslot.setImageResource(R.drawable.four);
        }
        else if(currentItem.getTimeslot().equals("5"))
        {
            holder.timeslot.setImageResource(R.drawable.five);
        }
        else if(currentItem.getTimeslot().equals("6"))
        {
            holder.timeslot.setImageResource(R.drawable.six);
        }
        else if(currentItem.getTimeslot().equals("7"))
        {
            holder.timeslot.setImageResource(R.drawable.seven);
        }
        else if(currentItem.getTimeslot().equals("8"))
        {
            holder.timeslot.setImageResource(R.drawable.eight);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

            if(status == 1)
            {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:

                                Intent i = new Intent(view.getContext(), MainActivity.class);
                                view.getContext().startActivity(i);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                Intent i1 = new Intent(view.getContext(),MainActivity.class);
                                view.getContext().startActivity(i1);
                                break;
                        }
                    }
                };
                Context c = view.getContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setMessage("Select an option")
                        .setPositiveButton("Venue Change", dialogClickListener)
                        .setNegativeButton("Cancel Class", dialogClickListener).show();

            }
            else
            {
                Toast.makeText(view.getContext(), "Student", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }


    @Override
    public int getItemCount() {
        return timetablelist.size();
    }
}
