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

import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import xyz.tgprojects.seamless.R;
import xyz.tgprojects.seamless.RideActivity;

public class RidersAdapter extends RecyclerView.Adapter<RidersAdapter.ViewHolder> implements View.OnClickListener{
    private List<String> mDataset;
    private List<String> dist;
    private Context c;
    private Picasso picasso;

    public void addRiders(String name, String dist){
        mDataset.add(name);
        this.dist.add(dist);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView distanceView;
        public LinearLayout layout;
        public CircleImageView circleImageView;
        public ViewHolder(View v) {
            super(v);
            layout = (LinearLayout) v.findViewById(R.id.rider_card_layout);
            mTextView = (TextView) v.findViewById(R.id.card_name);
            distanceView = (TextView) v.findViewById(R.id.card_description);
            circleImageView = (CircleImageView) v.findViewById(R.id.card_imageview);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RidersAdapter(Context c, List<String>myDataset, List<String> dist, Picasso picasso) {
        Log.d("ddd",dist.toString());
        mDataset = myDataset;
        this.dist = dist;
        this.c = c;
        this.picasso = picasso;
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
        holder.mTextView.setText(mDataset.get(position));
        holder.distanceView.setText(dist.get(position));
        holder.layout.setOnClickListener(this);

        switch(position) {
            case 0:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person1));
                picasso.load(R.drawable.person1).into(holder.circleImageView);
                break;
            case 1:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person2));
                picasso.load(R.drawable.person2).into(holder.circleImageView);
                break;
            case 2:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person3));
                picasso.load(R.drawable.person3).into(holder.circleImageView);
                break;
            case 3:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person4));
                picasso.load(R.drawable.person4).into(holder.circleImageView);
                break;
            case 4:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person2));
                picasso.load(R.drawable.person3).into(holder.circleImageView);
                break;
            case 5:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person1));
                picasso.load(R.drawable.person1).into(holder.circleImageView);
                break;

            default:
                //holder.circleImageView.setImageDrawable(c.getResources().getDrawable(R.drawable.person4));
                picasso.load(R.drawable.person4).into(holder.circleImageView);
                break;
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override public void onClick(View v) {
        Intent i = new Intent(c, RideActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }
}


