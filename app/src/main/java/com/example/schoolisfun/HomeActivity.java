package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    boolean chat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    // Permet de gerer le radio boutton du choix entre l'enfant et le parent

}