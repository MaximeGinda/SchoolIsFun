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
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    AppCompatRadioButton rbParent, rbChild;
    EditText etEmail, etPassword;
    ImageButton ibGoogle;
    int nbClickRB;
    boolean parent = true;

    RoomDB database;
    List<ChildData> childDataList = new ArrayList<>();

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

        // Validation des données et fragment suivant
        Button signUp = (Button) findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

//        // Reset de la database si clic sur le bouton Google
        ibGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete all data from database
                database.childDao().reset(childDataList);
                database.courseContentDao().reset(database.courseContentDao().getAll());
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
                    // Si sélectionné
                    parent = true;
                }
                break;
            case R.id.rbChild:
                if (isSelected) {
                    // Si sélectionné
                    parent = false;
                }
                break;
        }
    }
}