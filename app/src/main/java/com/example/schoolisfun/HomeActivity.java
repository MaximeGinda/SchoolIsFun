package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    boolean classes = true;
    LinearLayout layoutClasses;
    LinearLayout layoutChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layoutClasses = (LinearLayout) findViewById(R.id.classes);
        layoutChat = (LinearLayout) findViewById(R.id.chat);
    }

    // Permet de gerer le radio boutton du choix entre l'enfant et le parent
    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbClasses:
                if (isSelected) {
                    // Si sélectionné
                    layoutClasses.setVisibility(View.VISIBLE);
                    layoutChat.setVisibility(View.INVISIBLE);
                    classes = true;
                }
                break;
            case R.id.rbChat:
                if (isSelected) {
                    // Si sélectionné
                    layoutClasses.setVisibility(View.INVISIBLE);
                    layoutChat.setVisibility(View.VISIBLE);
                    classes = false;
                }
                break;
        }
    }
}