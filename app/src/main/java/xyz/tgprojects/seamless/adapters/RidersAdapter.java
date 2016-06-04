package xyz.tgprojects.seamless.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import xyz.tgprojects.seamless.R;
import xyz.tgprojects.seamless.RideActivity;

public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.ViewHolder> implements View.OnClickListener{
    private String[] mDataset;
    private String[] dist;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView distanceView;
        public LinearLayout layout;
        public ViewHolder(View v) {
            super(v);
            layout = (LinearLayout) v.findViewById(R.id.rider_card_layout);
            mTextView = (TextView) v.findViewById(R.id.card_name);
            distanceView = (TextView) v.findViewById(R.id.card_description);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RidersAdapter(Context c, String[]myDataset, String[] dist) {
        Log.d("ddd",dist.toString());
        this.context = c;
        mDataset = myDataset;
        this.dist = dist;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RidersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rider_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
        holder.distanceView.setText(dist[position]);
        holder.layout.setOnClickListener(this);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override public void onClick(View v) {
        Intent i = new Intent(context, RideActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}


