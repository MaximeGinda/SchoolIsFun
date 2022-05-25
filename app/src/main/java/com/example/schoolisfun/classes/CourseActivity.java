package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.schoolisfun.HomeActivity;
import com.example.schoolisfun.R;
import com.example.schoolisfun.data.CourseContentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;
import com.example.schoolisfun.ui.login.LoginActivity;

public class CourseActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    LinearLayout courseSummary;
    LinearLayout video;
    LinearLayout quiz;

    ImageView checked1;
    ImageView checked2;
    ImageView checked4;

    // BDD
    RoomDB database;
    RoomDBcontent databaseContent;
    String nameClasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        courseSummary = (LinearLayout) findViewById(R.id.llSummary);
        video = (LinearLayout) findViewById(R.id.llVideo);
        quiz = (LinearLayout) findViewById(R.id.llQuiz);

        checked1 = (ImageView) findViewById(R.id.checked1);
        checked2 = (ImageView) findViewById(R.id.checked2);
        checked4 = (ImageView) findViewById(R.id.checked4);

        ImageView fleche1 = (ImageView) findViewById(R.id.fleche3);
        ImageView fleche2 = (ImageView) findViewById(R.id.fleche2);
        ImageView fleche4 = (ImageView) findViewById(R.id.fleche4);

        //Initialize database
        database = RoomDB.getInstance(this);

        TextView title = (TextView) findViewById(R.id.courseTv);

        if(getIntent().getIntExtra("classe", 0) == 1){
            title.setText("Physics");
            title.setBackgroundColor(getResources().getColor(R.color.physics));
            courseSummary.setBackground(getResources().getDrawable(R.drawable.buttonphysics));
            video.setBackground(getResources().getDrawable(R.drawable.buttonphysics));
            quiz.setBackground(getResources().getDrawable(R.drawable.buttonphysics));

            fleche1.setImageResource(R.drawable.physics);
            fleche2.setImageResource(R.drawable.physics);
            fleche4.setImageResource(R.drawable.physics);

            nameClasse = "Physics";

            if (database.childDao().findboolSPWithId(getIntent().getIntExtra("id", 0))){
                checked1.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolVPWithId(getIntent().getIntExtra("id", 0))){
                checked2.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolQPWithId(getIntent().getIntExtra("id", 0))){
                checked4.setImageResource(R.drawable.checked);
            }
        }
        else if(getIntent().getIntExtra("classe", 0) == 2){
            title.setText("Mathematics");
            title.setBackgroundColor(getResources().getColor(R.color.math));

            courseSummary.setBackground(getResources().getDrawable(R.drawable.buttonmaths));
            video.setBackground(getResources().getDrawable(R.drawable.buttonmaths));
            quiz.setBackground(getResources().getDrawable(R.drawable.buttonmaths));

            fleche2.setImageResource(R.drawable.right_math);
            fleche1.setImageResource(R.drawable.right_math);
            fleche4.setImageResource(R.drawable.right_math);

            nameClasse = "Mathematics";

            if (database.childDao().findboolSMWithId(getIntent().getIntExtra("id", 0))){
                checked1.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolVMWithId(getIntent().getIntExtra("id", 0))){
                checked2.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolQMWithId(getIntent().getIntExtra("id", 0))){
                checked4.setImageResource(R.drawable.checked);
            }
        }
        else if(getIntent().getIntExtra("classe", 0) == 3){
            title.setText("Computer Science");
            title.setBackgroundColor(getResources().getColor(R.color.cs));

            courseSummary.setBackground(getResources().getDrawable(R.drawable.buttoncs));
            video.setBackground(getResources().getDrawable(R.drawable.buttoncs));
            quiz.setBackground(getResources().getDrawable(R.drawable.buttoncs));

            fleche1.setImageResource(R.drawable.cs);
            fleche2.setImageResource(R.drawable.cs);
            fleche4.setImageResource(R.drawable.cs);

            nameClasse = "Computer Science";

            if (database.childDao().findboolSCSWithId(getIntent().getIntExtra("id", 0))){
                checked1.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolVCSWithId(getIntent().getIntExtra("id", 0))){
                checked2.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolQCSWithId(getIntent().getIntExtra("id", 0))){
                checked4.setImageResource(R.drawable.checked);
            }
        }
        else if(getIntent().getIntExtra("classe", 0) == 4){
            title.setText("English");
            title.setBackgroundColor(getResources().getColor(R.color.english));

            courseSummary.setBackground(getResources().getDrawable(R.drawable.buttonenglish));
            video.setBackground(getResources().getDrawable(R.drawable.buttonenglish));
            quiz.setBackground(getResources().getDrawable(R.drawable.buttonenglish));

            fleche1.setImageResource(R.drawable.english);
            fleche2.setImageResource(R.drawable.english);
            fleche4.setImageResource(R.drawable.english);

            nameClasse = "English";

            if (database.childDao().findboolSEWithId(getIntent().getIntExtra("id", 0))){
                checked1.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolVEWithId(getIntent().getIntExtra("id", 0))){
                checked2.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolQEWithId(getIntent().getIntExtra("id", 0))){
                checked4.setImageResource(R.drawable.checked);
            }
        }
        else if(getIntent().getIntExtra("classe", 0) == 5){
            title.setText("French");
            title.setBackgroundColor(getResources().getColor(R.color.french));

            courseSummary.setBackground(getResources().getDrawable(R.drawable.buttonfrench));
            video.setBackground(getResources().getDrawable(R.drawable.buttonfrench));
            quiz.setBackground(getResources().getDrawable(R.drawable.buttonfrench));

            fleche1.setImageResource(R.drawable.french);
            fleche2.setImageResource(R.drawable.french);
            fleche4.setImageResource(R.drawable.french);

            nameClasse = "French";

            if (database.childDao().findboolSFWithId(getIntent().getIntExtra("id", 0))){
                checked1.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolVFWithId(getIntent().getIntExtra("id", 0))){
                checked2.setImageResource(R.drawable.checked);
            }
            if (database.childDao().findboolQFWithId(getIntent().getIntExtra("id", 0))){
                checked4.setImageResource(R.drawable.checked);
            }
        }

        courseSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSummary = new Intent(CourseActivity.this, CourseSummaryActivity.class);
                intentSummary.putExtra("id", getIntent().getIntExtra("id", 0));
                intentSummary.putExtra("courseName", nameClasse);
                intentSummary.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(intentSummary);
                finish();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuiz = new Intent(CourseActivity.this, QuizActivity.class);
                intentQuiz.putExtra("id", getIntent().getIntExtra("id", 0));
                intentQuiz.putExtra("courseName", nameClasse);
                intentQuiz.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(intentQuiz);
                finish();
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoActivity = new Intent(CourseActivity.this, VideoActivity.class);
                videoActivity.putExtra("id", getIntent().getIntExtra("id", 0));
                videoActivity.putExtra("courseName", nameClasse);
                videoActivity.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(videoActivity);
                finish();
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
                Intent home = new Intent(CourseActivity.this, HomeActivity.class);
                home.putExtra("id", getIntent().getIntExtra("id", 0));
                startActivity(home);
                finish();
                return true;
            case R.id.disconnect:
                Intent login = new Intent(CourseActivity.this, LoginActivity.class);
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
}