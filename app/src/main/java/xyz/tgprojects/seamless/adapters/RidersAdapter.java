package xyz.tgprojects.seamless.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import xyz.tgprojects.seamless.R;
import xyz.tgprojects.seamless.RideActivity;

public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.ViewHolder> {

    Context context;

    public RidersAdapter(Context context){
        this.context = context;
    }


    @Override public RidersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rider_card, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(RidersAdapter.ViewHolder holder, int position) {
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                context.startActivity(new Intent(context, RideActivity.class));
            }
        });
    }

    @Override public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        ImageView imageView;
        TextView name;
        TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.ride_card);
            imageView = (ImageView) itemView.findViewById(R.id.card_imageview);
            name = (TextView) itemView.findViewById(R.id.card_name);
            description = (TextView) itemView.findViewById(R.id.card_description);
        }
    }
}
