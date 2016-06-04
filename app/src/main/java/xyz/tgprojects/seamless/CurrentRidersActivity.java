package xyz.tgprojects.seamless;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import xyz.tgprojects.seamless.adapters.RidersAdapter;

public class CurrentRidersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RidersAdapter adapter;

    FloatingActionButton fab;

    Toolbar toolbar;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_riders);

        recyclerView = (RecyclerView) findViewById(R.id.riders_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
         List<String> names = new ArrayList<String>() {{
            add("Kyle Potts");
            add("Ben Wencke");
            add("Mike Hockerman");
            add("Tylor Garrett");
        }};

        List<String> dist = new ArrayList<String>() {{
            add("0.9 miles");
            add("0.5 miles");
            add("1.2 miles");
            add("0.6 miles");
        }};
        Picasso picasso = Picasso.with(this);
        adapter = new RidersAdapter(this.getApplicationContext(),names, dist, picasso);
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Rides Near You");
        setSupportActionBar(toolbar);
        final Context c = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //showCreateDialog()
                SharedPreferences sharedPref = c.getSharedPreferences(
                        "prefs", Context.MODE_PRIVATE);
                String name = sharedPref.getString("name","");
                adapter.addRiders(name,"0.1 miles");
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.riders_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == R.id.menu_profile ){
            startActivity(new Intent(this, ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    public void showCreateDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.create_ride_dialog);
        dialog.setTitle("Create A Ride");
        dialog.show();
    }
}
