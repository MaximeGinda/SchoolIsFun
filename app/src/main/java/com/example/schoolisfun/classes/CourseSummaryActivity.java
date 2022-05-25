package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;

import ru.noties.markwon.Markwon;


public class CourseSummaryActivity extends AppCompatActivity {

    RoomDBcontent databaseContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_summary);

        databaseContent = RoomDBcontent.getInstance(this);

        Markwon.setMarkdown((TextView) findViewById(R.id.text), databaseContent.courseContentDao().findSummaryWithID(getIntent().getIntExtra("id", 0),getIntent().getStringExtra("courseName")));

        findViewById(R.id.quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseContent.courseContentDao().updateBoolSummary(true, getIntent().getIntExtra("id", 0), getIntent().getStringExtra("courseName"));
                Intent coursePage = new Intent(CourseSummaryActivity.this, CourseActivity.class);
                coursePage.putExtra("id", getIntent().getIntExtra("id", 0));
                coursePage.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(coursePage);
                finish();
            }
        });
    }

}