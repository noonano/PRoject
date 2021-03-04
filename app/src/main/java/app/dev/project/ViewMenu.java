package app.dev.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class ViewMenu extends Fragment {

    LinearLayout home, journal, share, rate, homeColor, journalColor;
    Switch theme;
    public ViewMenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_menu, container, false);

        home = (LinearLayout) view.findViewById(R.id.home);
        journal = (LinearLayout) view.findViewById(R.id.journal);
        share = (LinearLayout) view.findViewById(R.id.share);
        rate = (LinearLayout) view.findViewById(R.id.rate);
        homeColor = (LinearLayout) view.findViewById(R.id.homeColor);
        journalColor = (LinearLayout) view.findViewById(R.id.journalColor);

        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), JournalNotes.class);
                startActivity(intent1);
            }
        });

        theme = (Switch)view.findViewById(R.id.theme_switch);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            theme.setChecked(true);

        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Intent i = new Intent(getContext(), Category_Selection.class);
                    startActivity(i);
                    //finish();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Intent i = new Intent(getContext(), Category_Selection.class);
                    startActivity(i);
                    //finish();
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Share", Toast.LENGTH_SHORT).show();
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Rate", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
