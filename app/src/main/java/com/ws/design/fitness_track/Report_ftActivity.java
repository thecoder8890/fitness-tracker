package com.ws.design.fitness_track;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.DateAdapter;
import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import model.DateModel;

public class Report_ftActivity extends AppCompatActivity {

    private LineChartView chart;
    private LineChartData data;

    //date picker
    List<DateModel> dates;
    RecyclerView datesReycler;
    DateAdapter dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_ft);

        dates = new ArrayList<>();

        //calender code

        datesReycler = findViewById(R.id.date_picker);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Report_ftActivity.this,LinearLayoutManager.HORIZONTAL,false);

        datesReycler.setLayoutManager(layoutManager);
        datesReycler.setItemAnimator(new DefaultItemAnimator());

        dateAdapter = new DateAdapter(Report_ftActivity.this, (ArrayList<DateModel>) dates);
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

//        graph code

        chart = findViewById(R.id.chart);
        generateTempoData();
    }

    private void generateTempoData() {
        // I got speed in range (0-50) and height in meters in range(200 - 300). I want this chart to display both
        // information. Differences between speed and height values are large and chart doesn't look good so I need
        // to modify height values to be in range of speed values.

        // The same for displaying Tempo/Height chart.

        float minHeight = 200;
        float maxHeight = 300;
        float tempoRange = 15; // from 0min/km to 15min/km

        float scale = tempoRange / maxHeight;
        float sub = (minHeight * scale) / 2;

        int numValues = 52;

        Line line;
        List<PointValue> values;
        List<Line> lines = new ArrayList<Line>();


        // Height line, add it as first line to be drawn in the background.
        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random height values, add +200 to make line a little more natural
            float rawHeight = (float) (Math.random() * 100 + 200);
            float normalizedHeight = rawHeight * scale - sub;
            values.add(new PointValue(i, normalizedHeight));
        }

        line = new Line(values);
        line.setColor(Color.parseColor("#0960bd"));
        line.setHasPoints(false);
        line.setFilled(true);
        line.setStrokeWidth(1);
        lines.add(line);

        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {

            float realTempo = (float) Math.random() * 6 + 2;
            float revertedTempo = tempoRange - realTempo;
            values.add(new PointValue(i, revertedTempo));
        }

        data = new LineChartData(lines);

        Axis distanceAxis = new Axis();

        distanceAxis.setName("Dates");
        distanceAxis.setTextColor(ChartUtils.DEFAULT_DARKEN_COLOR);
        distanceAxis.setMaxLabelChars(4);
        distanceAxis.setLineColor(Color.parseColor("#9b9ca1"));

//        1213
        distanceAxis.setFormatter(new SimpleAxisValueFormatter().setAppendedText("".toCharArray()));
        distanceAxis.setHasLines(true);
        distanceAxis.setHasTiltedLabels(true);
        data.setAxisXBottom(distanceAxis);
        distanceAxis.setHasLines(false);

        List<AxisValue> axisValues = new ArrayList<AxisValue>();
        for (float i = 0; i < tempoRange; i += 0.25f) {
            axisValues.add(new AxisValue(i).setLabel(formatMinutes(tempoRange - i)));
        }


        chart.setLineChartData(data);
        Viewport v = chart.getMaximumViewport();
        v.set(v.left, tempoRange, v.right, 0);

        Axis tempoAxis = new Axis(axisValues).setName("lbs").setHasLines(false).setMaxLabelChars(4)
                .setTextColor(ChartUtils.DEFAULT_DARKEN_COLOR);
        data.setAxisYLeft(tempoAxis);

        // * Same as in Speed/Height chart.
        // Height axis, this axis need custom formatter that will translate values back to real height values.
        data.setAxisYRight(new Axis().setName("").setMaxLabelChars(0)
                .setFormatter(new HeightValueFormatter(scale, sub, 0)));

        // Set data

        // Important: adjust viewport, you could skip this step but in this case it will looks better with custom
        // viewport. Set
        // viewport with Y range 0-12;

        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);
    }

    private String formatMinutes(float value) {
        StringBuilder sb = new StringBuilder();

        // translate value to seconds, for example
        int valueInSeconds = (int) (value * 60);
        int minutes = (int) Math.floor(valueInSeconds / 60);
        int seconds = (int) valueInSeconds % 60;

        sb.append(String.valueOf(minutes)).append(':');
        if (seconds < 5) {
            sb.append('0');
        }
        sb.append(String.valueOf(seconds));
        return sb.toString();
    }

    /**
     * Recalculated height values to display on axis. For this example I use auto-generated height axis so I
     * override only formatAutoValue method.
     */
    private static class HeightValueFormatter extends SimpleAxisValueFormatter {

        private float scale;
        private float sub;
        private int decimalDigits;

        public HeightValueFormatter(float scale, float sub, int decimalDigits) {
            this.scale = scale;
            this.sub = sub;
            this.decimalDigits = decimalDigits;
        }

        @Override
        public int formatValueForAutoGeneratedAxis(char[] formattedValue, float value, int autoDecimalDigits) {
            float scaledValue = (value + sub) / scale;
            return super.formatValueForAutoGeneratedAxis(formattedValue, scaledValue, this.decimalDigits);
        }
    }
}