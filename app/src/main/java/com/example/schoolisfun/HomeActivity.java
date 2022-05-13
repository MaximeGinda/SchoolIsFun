package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.schoolisfun.classes.CourseActivity;
import com.example.schoolisfun.data.Converters;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.ui.login.LoginActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {


    // Layouts / utilisée pour l'affichage
    private boolean classes = true;
    private LinearLayout layoutClasses;
    private LinearLayout layoutChatPremium;
    private LinearLayout layoutChatNotPremium;


    // données de l'utilisateur
    private int UserId;
    private ArrayList<String> listClasses;
    private boolean premium;
    private int percentageMath;
    private int percentageEng;
    private int percentageFre;
    private int percentageCS;
    private int percentagePhy;


    // BDD
    private RoomDB database;
    public static boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(isConnected) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);


            //Initialize database
            database = RoomDB.getInstance(this);

            Converters conv = new Converters();

            // Requete BDD
            UserId = (int) getIntent().getIntExtra("id", 0);

            listClasses = (ArrayList<String>) database.childDao().findClassesWithID(UserId);
            listClasses = conv.fromString(listClasses.get(0));

            premium = (boolean) database.childDao().findPremiumWithId(UserId);

            // On récupère les layouts
            layoutClasses = (LinearLayout) findViewById(R.id.classes);
            layoutChatPremium = (LinearLayout) findViewById(R.id.chatP);
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

            calculPourcentage();
            ProgressBar pbMath = (ProgressBar) findViewById(R.id.progressBarMath);
            pbMath.setProgress(percentageMath);

            ProgressBar pbPhy = (ProgressBar) findViewById(R.id.progressBarPhy);
            pbPhy.setProgress(percentagePhy);

            ProgressBar pbCS = (ProgressBar) findViewById(R.id.progressBarCS);
            pbCS.setProgress(percentageCS);

            ProgressBar pbEng = (ProgressBar) findViewById(R.id.progressBarEng);
            pbEng.setProgress(percentageEng);

            ProgressBar pbFre = (ProgressBar) findViewById(R.id.progressBarFre);
            pbFre.setProgress(percentageFre);

            // ------ PROGRESS BARS ----- ///
            if(percentageMath > 50){
                pbMath.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else if(percentageMath > 25){
                pbMath.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            else{
                pbMath.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }

            if(percentageCS > 50){
                pbCS.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else if(percentageCS > 25){
                pbCS.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            else{
                pbCS.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }

            if(percentagePhy > 50){
                pbPhy.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else if(percentagePhy > 25){
                pbPhy.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            else{
                pbPhy.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }

            if(percentageEng > 50){
                pbEng.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else if(percentageEng > 25){
                pbEng.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            else{
                pbEng.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }

            if(percentageFre > 50){
                pbFre.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else if(percentageFre > 25){
                pbFre.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            else{
                pbFre.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
        }

    }

    // Permet de gerer le radio boutton du choix entre l'enfant et le parent
    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbClasses:
                if (isSelected) {
                    // Si sélectionné
                    layoutClasses.setVisibility(View.VISIBLE);

                    if (premium) {
                        layoutChatPremium.setVisibility(View.INVISIBLE);
                    } else {
                        layoutChatNotPremium.setVisibility(View.INVISIBLE);
                    }
                    classes = true;
                }
                break;
            case R.id.rbChat:
                if (isSelected) {
                    // Si sélectionné
                    if (premium) {
                        layoutChatPremium.setVisibility(View.VISIBLE);
                    } else {
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
                for (int i = 0; i < listClasses.size(); i++) {
                    if (listClasses.get(i).contains("Physics")) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    Intent int1 = new Intent(HomeActivity.this, CourseActivity.class);
                    int1.putExtra("id", UserId);
                    int1.putExtra("classe", 1);
                    startActivity(int1);
                } else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id2:
                find = false;
                for (int i = 0; i < listClasses.size(); i++) {
                    if (listClasses.get(i).contains("Mathematics")) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    Intent int2 = new Intent(HomeActivity.this, CourseActivity.class);
                    int2.putExtra("id", UserId);
                    int2.putExtra("classe", 2);
                    startActivity(int2);
                } else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id3:
                find = false;
                for (int i = 0; i < listClasses.size(); i++) {
                    if (listClasses.get(i).contains("Computer Science")) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    Intent int3 = new Intent(HomeActivity.this, CourseActivity.class);
                    int3.putExtra("id", UserId);
                    int3.putExtra("classe", 3);
                    startActivity(int3);
                } else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id4:
                find = false;
                for (int i = 0; i < listClasses.size(); i++) {
                    if (listClasses.get(i).contains("English")) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    Intent int4 = new Intent(HomeActivity.this, CourseActivity.class);
                    int4.putExtra("id", UserId);
                    int4.putExtra("classe", 4);
                    startActivity(int4);
                } else {
                    Toast.makeText(HomeActivity.this, "Vous n'avez pas accès à ce cours", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.id5:
                find = false;
                for (int i = 0; i < listClasses.size(); i++) {
                    if (listClasses.get(i).contains("French")) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    Intent int5 = new Intent(HomeActivity.this, CourseActivity.class);
                    int5.putExtra("id", UserId);
                    int5.putExtra("classe", 5);
                    startActivity(int5);
                } else {
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
                home.putExtra("id", getIntent().getIntExtra("id", 0));

                startActivity(home);
                finish();
                return true;
            case R.id.disconnect:
                isConnected = false;
                Intent login = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    // Calcul le pourcentage pour les progress bar
    private void calculPourcentage(){
        percentageMath = 0;
        percentagePhy = 0;
        percentageEng = 0;
        percentageFre = 0;
        percentageCS = 0;

        // ----- EXERCICES ----- //
        if(database.courseContentDao().findboolExerciseWithID(getIntent().getIntExtra("id", 0),"Mathematics")){
            percentageMath += 25;
        }

        if(database.courseContentDao().findboolExerciseWithID(getIntent().getIntExtra("id", 0),"Physics")){
            percentagePhy += 25;
        }

        if(database.courseContentDao().findboolExerciseWithID(getIntent().getIntExtra("id", 0),"English")){
            percentageEng += 25;
        }

        if(database.courseContentDao().findboolExerciseWithID(getIntent().getIntExtra("id", 0),"French")){
            percentageFre += 25;
        }

        if(database.courseContentDao().findboolExerciseWithID(getIntent().getIntExtra("id", 0),"Computer Science")){
            percentageCS += 25;
        }


        // ----- VIDEOS ----- //
        if(database.courseContentDao().findboolVideoWithID(getIntent().getIntExtra("id", 0),"Mathematics")){
            percentageMath += 25;
        }

        if(database.courseContentDao().findboolVideoWithID(getIntent().getIntExtra("id", 0),"Physics")){
            percentagePhy += 25;
        }

        if(database.courseContentDao().findboolVideoWithID(getIntent().getIntExtra("id", 0),"English")){
            percentageEng += 25;
        }

        if(database.courseContentDao().findboolVideoWithID(getIntent().getIntExtra("id", 0),"French")){
            percentageFre += 25;
        }

        if(database.courseContentDao().findboolVideoWithID(getIntent().getIntExtra("id", 0),"Computer Science")){
            percentageCS += 25;
        }

        // ----- SUMMARY ----- //
        if(database.courseContentDao().findboolSummaryWithID(getIntent().getIntExtra("id", 0),"Mathematics")){
            percentageMath += 25;
        }

        if(database.courseContentDao().findboolSummaryWithID(getIntent().getIntExtra("id", 0),"Physics")){
            percentagePhy += 25;
        }

        if(database.courseContentDao().findboolSummaryWithID(getIntent().getIntExtra("id", 0),"English")){
            percentageEng += 25;
        }

        if(database.courseContentDao().findboolSummaryWithID(getIntent().getIntExtra("id", 0),"French")){
            percentageFre += 25;
        }

        if(database.courseContentDao().findboolSummaryWithID(getIntent().getIntExtra("id", 0),"Computer Science")){
            percentageCS += 25;
        }

        // ----- QUIZ ----- //
        if(database.courseContentDao().findboolQuizWithID(getIntent().getIntExtra("id", 0),"Mathematics")){
            percentageMath += 25;
        }

        if(database.courseContentDao().findboolQuizWithID(getIntent().getIntExtra("id", 0),"Physics")){
            percentagePhy += 25;
        }

        if(database.courseContentDao().findboolQuizWithID(getIntent().getIntExtra("id", 0),"English")){
            percentageEng += 25;
        }

        if(database.courseContentDao().findboolQuizWithID(getIntent().getIntExtra("id", 0),"French")){
            percentageFre += 25;
        }

        if(database.courseContentDao().findboolQuizWithID(getIntent().getIntExtra("id", 0),"Computer Science")){
            percentageCS += 25;
        }

    }
}