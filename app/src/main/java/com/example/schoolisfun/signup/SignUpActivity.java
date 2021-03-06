package com.example.schoolisfun.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.ParentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;
import com.example.schoolisfun.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    AppCompatRadioButton rbParent, rbChild;
    private EditText etEmail, etPassword;
    private ImageButton ibGoogle;
    int nbClickRB;
    boolean parent = true;

    RoomDB database;
    RoomDBcontent databaseContent;
    private List<ChildData> childDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rbParent = findViewById(R.id.rbParent);
        rbChild = findViewById(R.id.rbChild);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        ibGoogle = findViewById(R.id.google);

        //Initialize database
        database = RoomDB.getInstance(this);
        //Store database value in data list
        childDataList = database.childDao().getAll();

        // Permet de reinitialiser le radioButton de policy
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbClickRB++;
                if (nbClickRB % 2 == 0) {
                    radioButton.setChecked(false);
                }
            }
        });

        // Permet de retourner sur la page login
        TextView signIn = (TextView) findViewById(R.id.signin);
        signIn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            }
        });

        // Validation des donn??es et fragment suivant
        Button signUp = (Button) findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Si on s'enregistre en tant que child
                if (!parent) {

                    //Get string from edit text
                    String emailText = etEmail.getText().toString().trim();
                    String passwordText = etPassword.getText().toString().trim();
                    //Check condition
                    if (database.childDao().findUserWithEmail(emailText).isEmpty()) {
                        if (!emailText.equals("") && emailText.contains("@") && passwordText.length() > 5) {
                            //When email and password are not empty and that email is not in database, Initialize main data
                            ChildData childData = new ChildData();
                            childData.setEmail(emailText);
                            childData.setPassword(passwordText);

                            //Clear edit text of password
                            etPassword.setText("");
                            //Notify when data is inserted
                            childDataList.clear();
                            Intent intent = new Intent(SignUpActivity.this, ChildInformationActivity.class);
                            intent.putExtra("child_data", childData);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Email must have an \"@\" \nPWD -> at least 6 characters", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Email already in database", Toast.LENGTH_SHORT).show();
                    }
                }
                else{ // En tant que Parent


                    //Get string from edit text
                    String emailText = etEmail.getText().toString().trim();
                    String passwordText = etPassword.getText().toString().trim();
                    if (database.childDao().findUserWithEmail(emailText).isEmpty()) {
                        if (!emailText.equals("") && emailText.contains("@") && passwordText.length() > 5) {
                            //When email and password are not empty and that email is not in database, Initialize main data
                            ParentData parentData = new ParentData();
                            parentData.setEmail(emailText);
                            parentData.setPassword(passwordText);

                            //Clear edit text of password
                            etPassword.setText("");
                            Intent intent = new Intent(SignUpActivity.this, ParentInformationActivity.class);
                            intent.putExtra("parent_data", parentData);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Email must have an \"@\" \nPWD -> at least 6 characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        // Reset de la database si clic sur le bouton Google
        ibGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete all data from database
                database.childDao().reset(childDataList);
                //databaseContent.courseContentDao().reset(databaseContent.courseContentDao().getAll());
                childDataList.clear();
                childDataList.addAll(database.childDao().getAll());
            }
        });
    }

    // Permet de gerer le radio boutton du choix entre l'enfant et le parent
    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbParent:
                if (isSelected) {
                    // Si s??lectionn??
                    parent = true;
                }
                break;
            case R.id.rbChild:
                if (isSelected) {
                    // Si s??lectionn??
                    parent = false;
                }
                break;
        }
    }
}