package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.example.schoolisfun.HomeActivity;
import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.CourseContentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.ui.login.LoginActivity;

public class MathActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    LinearLayout courseSummary;
    LinearLayout video;
    LinearLayout exercises;
    LinearLayout quiz;

    ImageView checked1;
    ImageView checked2;
    ImageView checked3;
    ImageView checked4;

    // BDD
    RoomDB database;
    CourseContentData courseContentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        courseSummary = (LinearLayout) findViewById(R.id.llSummary);
        video = (LinearLayout) findViewById(R.id.llVideo);
        exercises = (LinearLayout) findViewById(R.id.llExercises);
        quiz = (LinearLayout) findViewById(R.id.llQuiz);

        checked1 = (ImageView) findViewById(R.id.checked1);
        checked2 = (ImageView) findViewById(R.id.checked2);
        checked3 = (ImageView) findViewById(R.id.checked3);
        checked4 = (ImageView) findViewById(R.id.checked4);

        //Initialize database
        database = RoomDB.getInstance(this);

        courseContentData = new CourseContentData();
        courseContentData.setBoolSummary(false);
        courseContentData.setBoolVideo(false);
        courseContentData.setBoolExercise(true);
        courseContentData.setBoolQuiz(true);

        if (courseContentData.isBoolSummary()) {
            checked1.setImageResource(R.drawable.checked);
        }
        if (courseContentData.isBoolVideo()) {
            checked2.setImageResource(R.drawable.checked);
        }
        if (courseContentData.isBoolExercise()) {
            checked3.setImageResource(R.drawable.checked);
        }
        if (courseContentData.isBoolQuiz()) {
            checked4.setImageResource(R.drawable.checked);
        }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuiz = new Intent(MathActivity.this, QuizActivity.class);
                startActivity(intentQuiz);
            }
        });
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
                Intent home = new Intent(MathActivity.this, HomeActivity.class);
                startActivity(home);
                return true;
            case R.id.disconnect:
                Intent login = new Intent(MathActivity.this, LoginActivity.class);
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