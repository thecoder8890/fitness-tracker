package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ws.design.fitness_track.R;

import java.util.ArrayList;

import model.Workout_detailmodel;

public class Workout_detailadapter extends RecyclerView.Adapter<Workout_detailadapter.ViewHolder> {

    Context context;
    ArrayList<Workout_detailmodel>workout_detailmodels;

    public Workout_detailadapter(Context context, ArrayList<Workout_detailmodel> workout_detailmodels) {
        this.context = context;
        this.workout_detailmodels = workout_detailmodels;
    }

    @NonNull
    @Override
    public Workout_detailadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workoutdetail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Workout_detailadapter.ViewHolder holder, int position) {

        holder.image_1.setImageResource(workout_detailmodels.get(position).getImage_1());

        holder.jump.setText(workout_detailmodels.get(position).getJump());
        holder.number.setText(workout_detailmodels.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return workout_detailmodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_1;
        TextView jump,number;
        public ViewHolder(View itemView) {
            super(itemView);

            image_1 = itemView.findViewById(R.id.image_1);

            jump = itemView.findViewById(R.id.jump);
            number = itemView.findViewById(R.id.number);
        }
    }
}
