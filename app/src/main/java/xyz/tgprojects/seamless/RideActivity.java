package xyz.tgprojects.seamless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import xyz.tgprojects.seamless.adapters.RideAdapter;

public class RideActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;

    Button button;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        recyclerView = (RecyclerView) findViewById(R.id.ride_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        toolbar = (Toolbar) findViewById(R.id.ride_toolbar);
        toolbar.setTitle("Ride Details");
        setSupportActionBar(toolbar);

        RideAdapter rideAdapter = new RideAdapter();


        recyclerView.setAdapter(rideAdapter);

        button = (Button) findViewById(R.id.join_ride_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), JoinedRideActivity.class));
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ride_menu, menu);
        return true;
    }
}
