package com.ws.design.fitness_track;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Settings_ftActivity extends AppCompatActivity{

    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_ft);

        spinner = findViewById(R.id.spinner);

        List<String> list = new ArrayList<String>();
        list.add("30 Sec");
        list.add("40 Sec");
        list.add("50 Sec");
        list.add("70 Sec");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Settings_ftActivity.this, R.layout.item_spinnergreen,
                R.id.spinner_text1, list);
        spinner.setAdapter(dataAdapter);

        spinner1 = findViewById(R.id.spinner1);

        List<String> list1 = new ArrayList<String>();
        list1.add("15 Sec");
        list1.add("40 Sec");
        list1.add("15 Sec");
        list1.add("50 Sec");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(Settings_ftActivity.this, R.layout.item_spinnergreen1,
                R.id.spinner_text2, list1);
        spinner1.setAdapter(dataAdapter1);

        spinner2 = findViewById(R.id.spinner2);

        List<String> list2 = new ArrayList<String>();
        list2.add("7 am");
        list2.add("9 pm");
        list2.add("7 am");
        list2.add("10 pm");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(Settings_ftActivity.this, R.layout.item_spinnergreen2,
                R.id.spinner_text3, list2);
        spinner2.setAdapter(dataAdapter2);

        spinner3 = findViewById(R.id.spinner3);

        List<String> list3 = new ArrayList<String>();
        list3.add("English");
        list3.add("Gujrati");
        list3.add("Marati");
        list3.add("Hindi");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(Settings_ftActivity.this, R.layout.item_spinnergreen3,
                R.id.spinner_text4, list3);
        spinner3.setAdapter(dataAdapter3);

    }
}