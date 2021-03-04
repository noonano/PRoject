package app.dev.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Enda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.LightTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enda);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        TextView tvThanks = (TextView) findViewById(R.id.tvThanks);

        String name = SP.getString("name", "default");

        tvThanks.setText("Hope we lighten your day \n" + name + " !! \nThank You for using our App");    //Sample only to be editted

    }
}