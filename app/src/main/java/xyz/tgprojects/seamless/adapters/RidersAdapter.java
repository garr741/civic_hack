package xyz.tgprojects.seamless.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import xyz.tgprojects.seamless.R;

public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.ViewHolder> {



    @Override public RidersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rider_card, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(RidersAdapter.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.card_imageview);
            name = (TextView) itemView.findViewById(R.id.card_name);
            description = (TextView) itemView.findViewById(R.id.card_description);
        }
    }
}
