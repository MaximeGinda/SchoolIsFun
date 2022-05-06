package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.schoolisfun.classes.MathActivity;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.Converters;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    // Layouts / utilisée pour l'affichage
    boolean classes = true;
    LinearLayout layoutClasses;
    LinearLayout layoutChatPremium;
    LinearLayout layoutChatNotPremium;

    // données de l'utilisateur
    int UserId;
    ArrayList<String> listClasses;
    boolean premium;

    // BDD
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initialize database
        database = RoomDB.getInstance(this);

        Converters conv = new Converters();

        // Requete BDD
        UserId = (int) getIntent().getIntExtra("id",0);

        listClasses = (ArrayList<String>) database.childDao().findClassesWithID(UserId);
        listClasses = conv.fromString(listClasses.get(0));

        premium = (boolean)database.childDao().findPremiumWithId(UserId);

        // On récupère les layouts
        layoutClasses = (LinearLayout) findViewById(R.id.classes);
        layoutChatPremium = (LinearLayout) findViewById(R.id.chatP) ;
        layoutChatNotPremium = (LinearLayout) findViewById(R.id.chat);

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

                    if(premium){
                        layoutChatPremium.setVisibility(View.INVISIBLE);
                    }
                    else{
                        layoutChatNotPremium.setVisibility(View.INVISIBLE);
                    }
                    classes = true;
                }
                break;
            case R.id.rbChat:
                if (isSelected) {
                    // Si sélectionné
                    if(premium){
                        layoutChatPremium.setVisibility(View.VISIBLE);
                    }
                    else{
                        layoutChatNotPremium.setVisibility(View.VISIBLE);
                    }
                    layoutClasses.setVisibility(View.INVISIBLE);
                    classes = false;
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        boolean find = false;
        switch (v.getId()) {
            case R.id.id1:
                find = false;
                for(int i = 0; i < listClasses.size(); i++){
                    if(listClasses.get(i).contains("Physics")){
                        find = true;
                        break;
                    }
                }
                if(find){
                    Toast.makeText(HomeActivity.this, "Seul le cours Mathematics est fonctionnelle", Toast.LENGTH_LONG).show();
                    //Intent int1 = new Intent(HomeActivity.this, LoginActivity.class);
                    //int1.putExtra("id", UserId);
                    //startActivity(int1);
                }
                else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id2:
                find = false;
                for(int i = 0; i < listClasses.size(); i++){
                    if(listClasses.get(i).contains("Mathematics")){
                        find = true;
                        break;
                    }
                }
                if(find){
                    Intent int2 = new Intent(HomeActivity.this, MathActivity.class);
                    int2.putExtra("id", UserId);
                    startActivity(int2);
                }
                else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id3:
                find = false;
                for(int i = 0; i < listClasses.size(); i++){
                    if(listClasses.get(i).contains("Computer Science")){
                        find = true;
                        break;
                    }
                }
                if(find){
                    Toast.makeText(HomeActivity.this, "Seul le cours Mathematics est fonctionnelle", Toast.LENGTH_LONG).show();
                    //Intent int3 = new Intent(HomeActivity.this, LoginActivity.class);
                    //int3.putExtra("id", UserId);
                    //startActivity(int3);
                }
                else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id4:
                find = false;
                for(int i = 0; i < listClasses.size(); i++){
                    if(listClasses.get(i).contains("English")){
                        find = true;
                        break;
                    }
                }
                if(find){
                    Toast.makeText(HomeActivity.this, "Seul le cours Mathematics est fonctionnelle", Toast.LENGTH_LONG).show();
                    //Intent int4 = new Intent(HomeActivity.this, LoginActivity.class);
                    //int4.putExtra("id", UserId);
                    //startActivity(int4);
                }
                else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id5:
                find = false;
                for(int i = 0; i < listClasses.size(); i++){
                    if(listClasses.get(i).contains("French")){
                        find = true;
                        break;
                    }
                }
                if(find){
                    Toast.makeText(HomeActivity.this, "Seul le cours Mathematics est fonctionnelle", Toast.LENGTH_LONG).show();
                   // Intent int5 = new Intent(HomeActivity.this, LoginActivity.class);
                   // int5.putExtra("id", UserId);
                   // startActivity(int5);
                }
                else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    //////////BOUTON BURGER////////////////
    // POP UP bouton "burger"
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