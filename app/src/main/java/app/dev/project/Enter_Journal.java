package app.dev.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Enter_Journal extends AppCompatActivity {

    EditText editJournalName, editContent;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.LightTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter__journal);

        editJournalName = (EditText) findViewById(R.id.editJournalName);
        editContent = (EditText) findViewById(R.id.editContent);
        btnBack = (ImageView) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Enter_Journal.this, JournalNotes.class);
                intent.putExtra("JOURNAL_NAME", editJournalName.getText().toString().trim());
                intent.putExtra("CONTENT", editContent.getText().toString().trim());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}