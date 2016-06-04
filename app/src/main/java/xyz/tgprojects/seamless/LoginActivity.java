package xyz.tgprojects.seamless;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.login_button);


        loginButton.setOnClickListener(this);

    }

    @Override public void onClick(View v) {
        if ( v.getId() == R.id.login_button ){
            EditText editText =(EditText) findViewById(R.id.login_email);
            Context context = this;
            SharedPreferences sharedPref = context.getSharedPreferences(
                    "prefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", editText.getText().toString());
            editor.commit();
            Intent i = new Intent(this, CurrentRidersActivity.class);
            startActivity(i);
        }
    }
}
