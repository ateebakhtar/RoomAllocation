package com.example.roomallocation.Connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.roomallocation.Interfaces.TimetableInterface;
import com.example.roomallocation.Models.Data;
import com.example.roomallocation.Models.TimetableData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReallocateConnection extends AsyncTask<Void,Void,Void>
{
    String ID;
    String course;
    String section;
    int day;
    public ReallocateConnection(Context context,String course,String section, int day)  {
        this.cx = context;
        this.course = course;
        this.day = day;
        this.section = section;
    }

    Context cx;

    ProgressDialog progressDialog;

    @Override
    protected void onPostExecute(Void v) {
        // execution of result of Long time consuming operation
        progressDialog.dismiss();

    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(cx, "ProgressDialog", "Wait for "+ " seconds");
    }

    @Override
    protected Void doInBackground(Void... voids) {



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit m = new Retrofit.Builder()
                .baseUrl(Data.ip)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        TimetableInterface GDS = m.create(TimetableInterface.class);

        System.out.println("Hello from reallocate");
        Call<Boolean> call = GDS.reallocateclassroom(course,section,day);
        Response<Boolean> x = null;
        try
        {
            x = call.execute();
            System.out.println(x.body());

        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error");
        }

        return null;
    }
}
