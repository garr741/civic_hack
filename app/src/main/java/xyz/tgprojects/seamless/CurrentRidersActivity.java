package xyz.tgprojects.seamless;


import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        String[] names = {"Kyle Potts", "Ben Wencke", "Mike Hockerman", "Tylor Garrett", "Donald Trump"};
        String[] dist = {"0.8 miles", "2 miles", "0.1 miles", "1.3 miles", "1.1 miles"};
        adapter = new RidersAdapter(this.getApplicationContext(),names, dist);
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Rides Near You");
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showCreateDialog();
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
