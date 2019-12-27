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

import model.Home_model;

public class Home_adapter extends RecyclerView.Adapter<Home_adapter.ViewHolder> {

    Context context;
    ArrayList<Home_model>home_models;

    public Home_adapter(Context context, ArrayList<Home_model> home_models) {
        this.context = context;
        this.home_models = home_models;
    }

    @NonNull
    @Override
    public Home_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_adapter.ViewHolder holder, int position) {

        holder.full_body.setImageResource(home_models.get(position).getFull_body());
        holder.text_body.setText(home_models.get(position).getText_body());


        if(position == 2) {
            holder.text_challenge.setVisibility(View.GONE);
        }
        if(position == 3) {
            holder.text_challenge.setVisibility(View.GONE);
        }
        if(position == 4) {
            holder.text_challenge.setVisibility(View.GONE);
        }
        if(position == 5) {
            holder.text_challenge.setVisibility(View.GONE);
        }
        if(position == 6) {
            holder.text_challenge.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return home_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView full_body;
        TextView text_body,text_challenge;
        public ViewHolder(View itemView) {
            super(itemView);

            full_body = itemView.findViewById(R.id.full_body);
            text_body = itemView.findViewById(R.id.text_body);

            text_challenge = itemView.findViewById(R.id.text_challenge);
        }
    }
}
