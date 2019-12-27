package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ws.design.fitness_track.Home_ftActivity;
import com.ws.design.fitness_track.Mygoal_ftActivity;
import com.ws.design.fitness_track.R;
import com.ws.design.fitness_track.Report_ftActivity;
import com.ws.design.fitness_track.Settings_ftActivity;
import com.ws.design.fitness_track.Splash_ftActivity;
import com.ws.design.fitness_track.Workout_started_ftActivity;
import com.ws.design.fitness_track.Workoutdetail_ftActivity;

import java.util.ArrayList;

import model.Home_model;
import model.List_recyclemodel;

public class Listrecycle_adapter extends RecyclerView.Adapter<Listrecycle_adapter.ViewHolder> {

    Context context;
    ArrayList<List_recyclemodel>list_recyclemodels;

    public Listrecycle_adapter(Context context, ArrayList<List_recyclemodel> list_recyclemodels) {
        this.context = context;
        this.list_recyclemodels = list_recyclemodels;
    }

    @NonNull
    @Override
    public Listrecycle_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Listrecycle_adapter.ViewHolder holder, final int position) {

        holder.text_list.setText(list_recyclemodels.get(position).getText_list());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent i = new Intent(context,Splash_ftActivity.class);
                    context.startActivity(i); }

                else if (position == 1) {
                    Intent i = new Intent(context, Home_ftActivity.class);
                    context.startActivity(i); }

                else if (position == 2) {
                    Intent i = new Intent(context, Workoutdetail_ftActivity.class);
                    context.startActivity(i); }

                else if (position == 3) {
                    Intent i = new Intent(context, Workout_started_ftActivity.class);
                    context.startActivity(i); }
                else if (position == 4) {
                    Intent i = new Intent(context, Mygoal_ftActivity.class);
                    context.startActivity(i); }
                else if (position == 5) {
                    Intent i = new Intent(context, Report_ftActivity.class);
                    context.startActivity(i); }
                else if (position == 6) {
                    Intent i = new Intent(context, Settings_ftActivity.class);
                    context.startActivity(i); }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_recyclemodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_list;
        public ViewHolder(View itemView) {
            super(itemView);

            text_list = itemView.findViewById(R.id.text_list);
        }
    }
}
