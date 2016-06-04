package xyz.tgprojects.seamless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import xyz.tgprojects.seamless.adapters.RideAdapter;

public class RideActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;




    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        recyclerView = (RecyclerView) findViewById(R.id.ride_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        toolbar = (Toolbar) findViewById(R.id.ride_toolbar);
        setSupportActionBar(toolbar);

        RideAdapter rideAdapter = new RideAdapter();


        recyclerView.setAdapter(rideAdapter);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ride_menu, menu);
        return true;
    }
}
