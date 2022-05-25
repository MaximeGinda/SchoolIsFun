package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import android.os.Bundle;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.RoomDB;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;
    private RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        database = RoomDB.getInstance(this);

        videoView = (VideoView) findViewById(R.id.videoView);
        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("");

        //Location of Media File
        if(getIntent().getStringExtra("courseName").equals("Computer Science"))
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cs_reseaux);

        if(getIntent().getStringExtra("courseName").equals("Mathematics"))
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.math_decimaux);

        if(getIntent().getStringExtra("courseName").equals("French"))
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.french_determinants);

        if(getIntent().getStringExtra("courseName").equals("English"))
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.english_se_presenter);

        if(getIntent().getStringExtra("courseName").equals("Physics"))
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.phys_mouvement);


        //Starting VideView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        ImageButton quit = (ImageButton) findViewById(R.id.quit2);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float progression = ((float) videoView.getCurrentPosition() / (float) videoView.getDuration())*(float) 100;
                float seuil = 85; //85%
                Log.d("test", String.valueOf(progression)+ " %");
                if(progression > seuil)
                {
                    if(getIntent().getStringExtra("courseName").equals("Computer Science"))
                        database.childDao().updateboolVCSWithId(getIntent().getIntExtra("id", 0),true);

                    if(getIntent().getStringExtra("courseName").equals("Mathematics"))
                        database.childDao().updateboolVMWithId(getIntent().getIntExtra("id", 0),true);

                    if(getIntent().getStringExtra("courseName").equals("French"))
                        database.childDao().updateboolVFWithId(getIntent().getIntExtra("id", 0),true);

                    if(getIntent().getStringExtra("courseName").equals("English"))
                        database.childDao().updateboolVEWithId(getIntent().getIntExtra("id", 0),true);

                    if(getIntent().getStringExtra("courseName").equals("Physics"))
                        database.childDao().updateboolVPWithId(getIntent().getIntExtra("id", 0),true);
                }

                Intent coursePage = new Intent(VideoActivity.this, CourseActivity.class);
                coursePage.putExtra("id", getIntent().getIntExtra("id", 0));
                coursePage.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(coursePage);
                finish();
            }
        });
    }
}