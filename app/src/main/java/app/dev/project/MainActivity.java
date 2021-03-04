package app.dev.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startButton(View view) {
        EditText editTextName= (EditText) findViewById(R.id.name);
        String name = editTextName.getText().toString();

        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SP.edit().putString("name", name).commit();

        Intent intent = new Intent(this, Category_Selection.class);
        intent.putExtra("NAME", name);
        startActivity(intent);
    }
}