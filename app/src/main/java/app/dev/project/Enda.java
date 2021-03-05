package app.dev.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Enda extends AppCompatActivity {
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enda);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        TextView tvThanks = (TextView) findViewById(R.id.tvThanks);

        String name = SP.getString("name", "default");

        tvThanks.setText("Hope we lighten your day \n" + name + " !! \nThank You for using our App");    //Sample only to be editted
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enda.this, "Closing app... Thank you!", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });
    }
}