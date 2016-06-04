package xyz.tgprojects.seamless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(this);

    }

    @Override public void onClick(View v) {
        if ( v.getId() == R.id.login_button ){
            Intent i = new Intent(this, CurrentRidersActivity.class);
            startActivity(i);
        }
    }
}
