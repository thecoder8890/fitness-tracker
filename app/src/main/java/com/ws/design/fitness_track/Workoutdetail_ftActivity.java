package com.ws.design.fitness_track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.Workout_detailadapter;
import model.Workout_detailmodel;

public class Workoutdetail_ftActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Workout_detailadapter workout_detailadapter;
    private ArrayList<Workout_detailmodel> workout_detailmodels;

    Integer image_1[] = {R.drawable.jacks,R.drawable.triceps_dips,R.drawable.high_stepping,
            R.drawable.pushup,R.drawable.abdominal_crunches,R.drawable.squats_img,
            R.drawable.wall_sit,R.drawable.side_plank_left,R.drawable.side_plank_right};

    String jump[] = {"Jumping Jacks","Triceps Dips","High Stepping","Push-Ups","Abdominal Crunches",
    "Squats","Wall Sit","Side Plank Left","Side Plank Right"};
    String number[] ={"x 20","x 16","x 10","x 8","x 8","x 16","00:30","00:30","00:30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutdetail_ft);

        recyclerView = findViewById(R.id.recycle2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Workoutdetail_ftActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        workout_detailmodels = new ArrayList<>();

        for (int i = 0; i < image_1.length; i++) {
            Workout_detailmodel ab = new Workout_detailmodel(image_1[i],jump[i],number[i]);
            workout_detailmodels.add(ab);
        }
        workout_detailadapter = new Workout_detailadapter(Workoutdetail_ftActivity.this, workout_detailmodels);
        recyclerView.setAdapter(workout_detailadapter);
    }
}
