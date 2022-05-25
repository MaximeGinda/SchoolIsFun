package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;

import java.util.ArrayList;
import java.util.List;

import ru.noties.markwon.Markwon;


public class CourseSummaryActivity extends AppCompatActivity {

    RoomDBcontent databaseContent;
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_summary);

        databaseContent = RoomDBcontent.getInstance(this);
        database = RoomDB.getInstance(this);

        Markwon.setMarkdown((TextView) findViewById(R.id.text), databaseContent.courseContentDao().findSummaryWithID(getIntent().getStringExtra("courseName")));

        findViewById(R.id.quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getIntent().getStringExtra("courseName").equals("Computer Science"))
                    database.childDao().updateboolSCSWithId(getIntent().getIntExtra("id", 0),true);

                if(getIntent().getStringExtra("courseName").equals("Mathematics"))
                    database.childDao().updateboolSMWithId(getIntent().getIntExtra("id", 0),true);

                if(getIntent().getStringExtra("courseName").equals("French"))
                    database.childDao().updateboolSFWithId(getIntent().getIntExtra("id", 0),true);

                if(getIntent().getStringExtra("courseName").equals("English"))
                    database.childDao().updateboolSEWithId(getIntent().getIntExtra("id", 0),true);

                if(getIntent().getStringExtra("courseName").equals("Physics"))
                    database.childDao().updateboolSPWithId(getIntent().getIntExtra("id", 0),true);


                Intent coursePage = new Intent(CourseSummaryActivity.this, CourseActivity.class);
                coursePage.putExtra("id", getIntent().getIntExtra("id", 0));
                coursePage.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(coursePage);
                finish();
            }
        });
    }

}