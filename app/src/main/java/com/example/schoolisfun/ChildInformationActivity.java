package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class ChildInformationActivity extends AppCompatActivity {

    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_information);

        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.childFrameLayout, ChildInformation.class,null,"tag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    // Permet de passer du fragment 1 au 2 dans les informations de l'enfant
    public void fragment1to2(){

        System.out.println("test");
        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.childFrameLayout,ChildChoice.class,null,"tag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

}