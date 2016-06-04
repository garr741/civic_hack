package xyz.tgprojects.seamless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinedRideActivity extends AppCompatActivity {

    Button button;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_ride);

        button = (Button) findViewById(R.id.joined_ride_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
