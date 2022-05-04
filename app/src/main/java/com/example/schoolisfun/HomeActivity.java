package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.example.schoolisfun.ui.login.LoginActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    boolean classes = true;
    LinearLayout layoutClasses;
    LinearLayout layoutChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layoutClasses = (LinearLayout) findViewById(R.id.classes);
        layoutChat = (LinearLayout) findViewById(R.id.chat);

        LinearLayout one = findViewById(R.id.id1);
        one.setOnClickListener(this); // calling onClick() method
        LinearLayout two = findViewById(R.id.id2);
        two.setOnClickListener(this);
        LinearLayout three = findViewById(R.id.id3);
        three.setOnClickListener(this);
        LinearLayout Four = findViewById(R.id.id4);
        Four.setOnClickListener(this);
        LinearLayout Five = findViewById(R.id.id5);
        Five.setOnClickListener(this);


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
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id1:
                Intent int1 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(int1);
                break;
            case R.id.id2:
                Intent int2 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(int2);
                break;
            case R.id.id3:
                Intent int3 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(int3);
                break;
            case R.id.id4:
                Intent int4 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(int4);
                break;
            case R.id.id5:
                Intent int5 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(int5);
                break;
            default:
                break;
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.actions, popup.getMenu());
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent home = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(home);
                return true;
            case R.id.disconnect:
                Intent login = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(login);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}