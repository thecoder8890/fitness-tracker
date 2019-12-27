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

import model.DateModel;
import model.Home_model;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

    Context context;
    ArrayList<DateModel> home_models;

    public DateAdapter(Context context, ArrayList<DateModel> home_models) {
        this.context = context;
        this.home_models = home_models;
    }

    @NonNull
    @Override
    public DateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent,false);
        return new DateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DateAdapter.ViewHolder holder, final int position) {

        holder.date.setText(home_models.get(position).getDate());
        holder.day.setText(home_models.get(position).getDay());

        if (home_models.get(position).getSelected()) {
            holder.date.setVisibility(View.GONE);
            holder.img.setVisibility(View.VISIBLE);
        } else {
            holder.date.setVisibility(View.VISIBLE);
            holder.img.setVisibility(View.GONE);
        }

        holder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_models.get(position).setSelected(true);
                holder.date.setVisibility(View.GONE);
                holder.img.setVisibility(View.VISIBLE);
            }
        });

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_models.get(position).setSelected(false);
                holder.date.setVisibility(View.VISIBLE);
                holder.img.setVisibility(View.GONE);
            }
        });


        if(position == 2){
            holder.date_image.setImageResource(R.drawable.right);

        }
    }

    @Override
    public int getItemCount() {
        return home_models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, day;
        ImageView img,date_image;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.current_date);
            img = itemView.findViewById(R.id.date_image);
            day = itemView.findViewById(R.id.day_name);
            date_image = itemView.findViewById(R.id.date_image);
        }
    }
}
