package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.schoolisfun.ui.login.LoginActivity;

public class SignUpActivity extends AppCompatActivity {

    AppCompatRadioButton rbParent, rbChild;
    int nbClickRB;
    boolean parent = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rbParent = findViewById(R.id.rbParent);
        rbChild = findViewById(R.id.rbChild);

        // Permet de reinitialiser le radioButton de policy
        RadioButton radioButton = (RadioButton)findViewById (R.id.radioButton);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbClickRB++;
                if(nbClickRB%2 == 0) {
                    radioButton.setChecked(false);;
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
                if(!parent){
                    Intent intent = new Intent(SignUpActivity.this, ChildInformationActivity.class);
                    startActivity(intent);
                }
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