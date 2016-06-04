package xyz.tgprojects.seamless.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import xyz.tgprojects.seamless.R;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolder> {
    @Override public RideAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(RideAdapter.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
        return 7;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
