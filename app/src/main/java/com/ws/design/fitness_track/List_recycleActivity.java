package com.ws.design.fitness_track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.Home_adapter;
import adapter.Listrecycle_adapter;
import model.Home_model;
import model.List_recyclemodel;

public class List_recycleActivity extends AppCompatActivity {

    String text_list[] ={"1.Splash_ftActivity","2.Home_ftActivity","3.Workoutdetail_ftActivity","4.Workout_started_ftActivity","5.Mygoal_ftActivity",
            "6.Report_ftActivity","7.Settings_ftActivity"};

    private RecyclerView recyclerView;
    private Listrecycle_adapter listrecycle_adapter;
    private ArrayList<List_recyclemodel> list_recyclemodels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycle);

        recyclerView = findViewById(R.id.List_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(List_recycleActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        list_recyclemodels = new ArrayList<>();

        for (int i = 0; i < text_list.length; i++) {
            List_recyclemodel ab = new List_recyclemodel(text_list[i]);
            list_recyclemodels.add(ab);
        }
        listrecycle_adapter = new Listrecycle_adapter(List_recycleActivity.this, list_recyclemodels);
        recyclerView.setAdapter(listrecycle_adapter);
    }
}
