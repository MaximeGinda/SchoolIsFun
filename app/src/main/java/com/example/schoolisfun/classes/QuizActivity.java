package com.example.schoolisfun.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.Converters;
import com.example.schoolisfun.data.CourseContentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;

    int currentScore = 0;
    int questionAttempted = 1;
    int currentPos = 0;
    int nbQuestion = 5;
    int scoreThreshold = 4;

    // BDD
    RoomDBcontent databaseContent;
    String className = "Mathematics";
    ArrayList<String> quizData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Initialize variables
        questionTV = findViewById(R.id.tvQuestion);
        questionNumberTV = findViewById(R.id.tvQuestionAttempted);
        option1Btn = findViewById(R.id.btOption1);
        option2Btn = findViewById(R.id.btOption2);
        option3Btn = findViewById(R.id.btOption3);
        option4Btn = findViewById(R.id.btOption4);
        quizModelArrayList = new ArrayList<>();

        //Initialize database
        databaseContent = RoomDBcontent.getInstance(this);
        Converters conv = new Converters();
        quizData = (ArrayList<String>) databaseContent.courseContentDao().findQuizWithClassname(className);
        quizData = conv.fromString(quizData.get(0));

        getQuizQuestion(quizModelArrayList);

        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase()
                        .equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);

            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase()
                        .equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase()
                        .equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);

            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase()
                        .equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);

            }
        });

    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.llScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.tvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.btRestart);
        Button returnToCourseBtn = bottomSheetView.findViewById(R.id.btReturnToCourse);
        if (currentScore >= scoreThreshold) {
            scoreTV.setText("Your score is \n" + currentScore + "/" + nbQuestion + "\nCongratulations! You passed the Quiz!");
            databaseContent.courseContentDao().updateBoolQuiz(true,getIntent().getIntExtra("id", 0), getIntent().getStringExtra("courseName"));
        } else {
            scoreTV.setText("Your score is \n" + currentScore + "/" + nbQuestion + "\nYou Failed! Please rety later! ");
        }
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted = 1;
                currentPos = 0;
                setDataToViews(currentPos);
                currentScore = 0;

                bottomSheetDialog.dismiss();
            }
        });

        returnToCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReturnQuiz = new Intent(QuizActivity.this, CourseActivity.class);
                intentReturnQuiz.putExtra("id", getIntent().getIntExtra("id", 0));
                intentReturnQuiz.putExtra("classe",getIntent().getIntExtra("classe", 0));
                startActivity(intentReturnQuiz);
                finish();
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos) {
        if (questionAttempted == nbQuestion + 1) {
            questionNumberTV.setText("Questions Attempted : " + nbQuestion + "/" + nbQuestion);
        } else {
            questionNumberTV.setText("Questions Attempted : " + questionAttempted + "/" + nbQuestion);
        }
        if (questionAttempted == nbQuestion + 1) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        for (int i = 0; i < quizData.size(); i += 6) {
            quizModelArrayList.add(new QuizModel(quizData.get(i), quizData.get(i + 1), quizData.get(i + 2), quizData.get(i + 3), quizData.get(i + 4), quizData.get(i + 5)));
        }
    }
}
