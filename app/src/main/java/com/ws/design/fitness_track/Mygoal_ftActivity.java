package com.ws.design.fitness_track;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.DateAdapter;
import model.DateModel;

public class Mygoal_ftActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;

    //date picker
    List<DateModel> dates;
    RecyclerView datesReycler;
    DateAdapter dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygoal_ft);

         circularProgressBar = findViewById(R.id.circle_progress);
        circularProgressBar.setColor(ContextCompat.getColor(this, R.color.blue));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
//        circularProgressBar.setProgressBarWidth(getResources().getDimension(R.dimen.progressBarWidth));
//        circularProgressBar.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.backgroundProgressBarWidth));
        int animationDuration = 5500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(65, animationDuration);

        dates = new ArrayList<>();

//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("82",false));
//        dates.add(new DateModel("32",false));
//        dates.add(new DateModel("12",false));
//        dates.add(new DateModel("8",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));
//        dates.add(new DateModel("22",false));

        //calender code

        datesReycler = findViewById(R.id.date_picker);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Mygoal_ftActivity.this,LinearLayoutManager.HORIZONTAL,false);

        datesReycler.setLayoutManager(layoutManager);
        datesReycler.setItemAnimator(new DefaultItemAnimator());

        dateAdapter = new DateAdapter(Mygoal_ftActivity.this, (ArrayList<DateModel>) dates);
        datesReycler.setAdapter(dateAdapter);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 5);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int i = 1;

        for(int var5 = maxDay; i < var5; ++i) {
            cal.set(Calendar.DAY_OF_MONTH, i + 1);
            SimpleDateFormat outFormat = new SimpleDateFormat("EEE");
            String day = outFormat.format(cal.getTime());
            String var10003 = df.format(cal.getTime());

            if (i==2||i==3||i==4||i==5){
                dates.add(new DateModel(String.valueOf(i),true,day));

            }
            else {
                dates.add(new DateModel(String.valueOf(i),false,day));

            }
        }
    }
}
