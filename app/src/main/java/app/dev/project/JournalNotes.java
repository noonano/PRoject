package app.dev.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JournalNotes extends AppCompatActivity implements NotesAdapter.ItemClicked {

    TextView viewName, viewContent;
    ImageView btnAdd, delete;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Notes> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.LightTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_notes);

        hideFragment();

        btnAdd = (ImageView) findViewById(R.id.btnAdd);
        delete = (ImageView) findViewById(R.id.delete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JournalNotes.this, Enter_Journal.class);
                startActivityForResult(intent, 1);
            }
        });

        recycler();
    }

    public void hideFragment(){
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction()
                .hide(manager.findFragmentById(R.id.detailfragment))
                .addToBackStack(null)
                .commit();
    }

    void recycler(){
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<Notes>();

        myAdapter = new NotesAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String putName, putContent;

        putName = data.getStringExtra("JOURNAL_NAME");
        putContent = data.getStringExtra("CONTENT");

        list.add(new Notes(putName, putContent));
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int index) {
        viewName = (TextView)findViewById(R.id.viewJournalName);
        viewContent = (TextView)findViewById(R.id.viewContent);

        viewName.setText(list.get(index).getName());
        viewContent.setText(list.get(index).getContent());

        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction()
                .show(manager.findFragmentById(R.id.detailfragment))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onItemDelete(int index) {
        list.remove(index);
        myAdapter.notifyItemRemoved(index);
        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
    }
}