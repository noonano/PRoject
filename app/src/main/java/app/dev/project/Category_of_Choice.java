package app.dev.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Category_of_Choice extends AppCompatActivity {

    TextView tvCategory, tvQuote;
    Button btnNext;
    ImageView ivTheme1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_of_choice);

        tvCategory = (TextView) findViewById(R.id.tvCategory);
        tvQuote = (TextView) findViewById(R.id.tvQuote);
        ivTheme1 = (ImageView) findViewById(R.id.ivTheme1);

        String category = getIntent().getStringExtra("category");
        String quote = getIntent().getStringExtra("quote");
        String theme = getIntent().getStringExtra("theme");

        tvCategory.setText(category);
        tvQuote.setText(quote);

        switch (theme) {
            case "family":
                ivTheme1.setImageResource(R.drawable.family);
                break;
            case "love":
                ivTheme1.setImageResource(R.drawable.love);
                break;
            case "finance":
                ivTheme1.setImageResource(R.drawable.finance);
                break;
            case "career":
                ivTheme1.setImageResource(R.drawable.career);
                break;
            case "health":
                ivTheme1.setImageResource(R.drawable.health);
                break;
        }

        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category_of_Choice.this, Enda.class);
                startActivity(intent);
            }
        });
    }
}